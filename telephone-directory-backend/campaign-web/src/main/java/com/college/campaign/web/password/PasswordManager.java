package com.college.campaign.web.password;


import com.college.campaign.common.config.application.SystemConfig;
import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.util.MessageComposer;
import com.college.campaign.common.util.ResponseMsg;
import com.college.campaign.entities.model.AdminPasswordChangeLog;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.repository.AdminPasswordChangeLogRepository;
import com.college.campaign.repository.ApplicationUserRepository;
import com.college.campaign.web.password.dto.PasswordDetail;
import com.college.campaign.web.password.dto.PasswordPolicy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;
import java.util.List;


@Slf4j
@Component
@RequestScope
public class PasswordManager {

    @Autowired
    private SystemConfig systemConfig;
    @Autowired
    private PasswordValidator passwordValidator;
    @Autowired
    private PasswordConfigMapper passwordConfigMapper;
    @Autowired
    private AdminPasswordChangeLogRepository adminPasswordChangeLogRepository;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    private PasswordDetail passwordDetail;
    private ApplicationUser applicationUser;
    private TelephoneDirectoryResponses telephoneDirectoryResponses;

    public void init(ApplicationUser applicationUser, PasswordDetail passwordDetail) {
        this.applicationUser = applicationUser;
        this.passwordDetail = passwordDetail;
        this.telephoneDirectoryResponses = new TelephoneDirectoryResponses();
    }

    public TelephoneDirectoryResponses save(PasswordDetail passwordDetail, ApplicationUser applicationUser) {

        init(applicationUser, passwordDetail);
        TelephoneDirectoryResponses telephoneDirectoryResponses = isValid(passwordDetail.getPassword());
        if (telephoneDirectoryResponses.isSuccess()) {
            if (!passwordDetail.isAllowOldPassword()) {
                telephoneDirectoryResponses = checkTopPassword(applicationUser.getId());
            }
            if (telephoneDirectoryResponses.isSuccess()) {
                telephoneDirectoryResponses = updatePassword();
            }
        }
        return telephoneDirectoryResponses;
    }

    public TelephoneDirectoryResponses changePassword(ApplicationUser applicationUser, PasswordDetail passwordDetail) {

        init(applicationUser, passwordDetail);
        //validate password
        TelephoneDirectoryResponses telephoneDirectoryResponses = validChangePassword(applicationUser, passwordDetail);
        if (telephoneDirectoryResponses.isSuccess()) {
            telephoneDirectoryResponses = updatePassword();
        }
        return telephoneDirectoryResponses;
    }

    private TelephoneDirectoryResponses validChangePassword(ApplicationUser applicationUser, PasswordDetail passwordDetail) {

        TelephoneDirectoryResponses telephoneDirectoryResponses = validateOldPassword();

        if (telephoneDirectoryResponses.isSuccess()) {
            PasswordPolicy passwordPolicy = passwordConfigMapper.convertToAdminPasswordPolicyDTO();
            telephoneDirectoryResponses = validatePolicy(passwordDetail.getPassword(), passwordPolicy);

            if (telephoneDirectoryResponses.isSuccess()) {
                telephoneDirectoryResponses = checkTopPassword(applicationUser.getId());
            }
        }
        return telephoneDirectoryResponses;
    }

    private TelephoneDirectoryResponses updatePassword() {
        applicationUser.setLastPasswordChanged(new Date());
        applicationUser.setPassword(BCrypt.hashpw(String.valueOf(passwordDetail.getPassword()), BCrypt.gensalt()));
        applicationUserRepository.save(applicationUser);

        //log password change
        storePasswordUpdateLog();
        return ResponseMsg.successResponse(MsgConstant.Password.PASSWORD_MODIFY_SUCCESS);
    }

    public void storePasswordUpdateLog() {
        AdminPasswordChangeLog adminPasswordChangeLog = new AdminPasswordChangeLog();
        adminPasswordChangeLog.setPassword(BCrypt.hashpw(String.valueOf(passwordDetail.getPassword()), BCrypt.gensalt()));
        adminPasswordChangeLog.setUserId(applicationUser);
        adminPasswordChangeLog.setRecordedDate(new Date());

        adminPasswordChangeLogRepository.save(adminPasswordChangeLog);
    }

    protected TelephoneDirectoryResponses validateOldPassword() {

        boolean valid = BCrypt.checkpw(passwordDetail.getOldPassword(), applicationUser.getPassword());
        if (valid) {
            return new TelephoneDirectoryResponses(true);
        } else {
            log.error("Old password is incorrect.");
            return ResponseMsg.failureResponse(MsgConstant.Password.INVALID_PASSWORD_MESSAGE);
        }
    }


    protected TelephoneDirectoryResponses validatePolicy(String password, PasswordPolicy passwordPolicy) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        if (password.contains(" ")) {
            log.error("password contains space");
            telephoneDirectoryResponses.setSuccess(false);
            telephoneDirectoryResponses = MessageComposer.compose(telephoneDirectoryResponses, MsgConstant.Password.PASSWORD_POLICY_NOT_MATCHED,
                    MessageComposer.getParameters());

            return telephoneDirectoryResponses;
        }
        if (!StringUtils.isEmpty(password)) {

            if (passwordValidator.isValidPassword(password, passwordPolicy)) {
                telephoneDirectoryResponses.setSuccess(true);
            } else {
                log.error(passwordValidator.getMessage());

                telephoneDirectoryResponses.setSuccess(false);
                telephoneDirectoryResponses.setMessage(passwordValidator.getMessage());
            }
        } else {
            log.error("password is empty");
            telephoneDirectoryResponses.setSuccess(false);
            telephoneDirectoryResponses = MessageComposer.compose(telephoneDirectoryResponses, MsgConstant.Password.INVALID_PASSWORD_LENGTH,
                    MessageComposer.getParameters());
        }
        return telephoneDirectoryResponses;
    }

    private TelephoneDirectoryResponses checkTopPassword(long userId) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        int count = Integer.parseInt(systemConfig.adminPasswordConfig(AdminPasswordConfigConstant.LAST_PASSWORD_RESTRICT_COUNT));
        if (topNPassword(count)) {
            telephoneDirectoryResponses.setSuccess(true);
            return telephoneDirectoryResponses;
        } else {
            log.error("Recent used password is set");
            return ResponseMsg.failureResponse(MsgConstant.Password.RESTRICT_SAME_PASSWORD);
        }
    }

    private boolean topNPassword(int count) {

        List<AdminPasswordChangeLog> adminPasswordChangeLogList = adminPasswordChangeLogRepository.recentPasswordChangeLogs(applicationUser.getId(), PageRequest.of(0, count)).toList();
        if (!adminPasswordChangeLogList.isEmpty()) {
            for (AdminPasswordChangeLog changePasswordLog : adminPasswordChangeLogList) {
                if (BCrypt.checkpw(passwordDetail.getPassword(), changePasswordLog.getPassword())) {
                    return false;
                }
            }
        }
        return true;
    }

    protected TelephoneDirectoryResponses match(PasswordDetail passwordDetail, ApplicationUser applicationUser) {
        boolean valid = BCrypt.checkpw(passwordDetail.getPassword(), applicationUser.getPassword());
        if (valid) {
            telephoneDirectoryResponses.setSuccess(true);
        } else {
            boolean lowerPin = BCrypt.checkpw(passwordDetail.getPassword().trim().toLowerCase(), applicationUser.getPassword());
            if (lowerPin) {
                telephoneDirectoryResponses.setSuccess(true);
                return telephoneDirectoryResponses;
            }
            log.error("invalid login password provided.");
            return ResponseMsg.failureResponse(MsgConstant.Password.INVALID_PASSWORD_MESSAGE);
        }
        return telephoneDirectoryResponses;
    }

    public TelephoneDirectoryResponses isValid(String password) {
        PasswordPolicy passwordPolicy = passwordConfigMapper.convertToAdminPasswordPolicyDTO();
        return validatePolicy(password, passwordPolicy);
    }

}
