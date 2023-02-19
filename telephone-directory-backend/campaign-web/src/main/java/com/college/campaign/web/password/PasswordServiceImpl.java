package com.college.campaign.web.password;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.web.password.dto.ChangePasswordRequest;
import com.college.campaign.web.password.dto.PasswordDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private PasswordManager passwordManager;

    @Override
    public TelephoneDirectoryResponses save(PasswordDetail passwordDetail, ApplicationUser applicationUser) {
        return passwordManager.save(passwordDetail, applicationUser);
    }

    @Override
    public TelephoneDirectoryResponses changePassword(ApplicationUser applicationUser, ChangePasswordRequest changePasswordRequest) {
        PasswordDetail passwordDetail = new PasswordDetail();
        passwordDetail.setOldPassword(changePasswordRequest.getOldPassword());
        passwordDetail.setPassword(changePasswordRequest.getNewPassword());
        passwordDetail.setAllowOldPassword(false);
        return passwordManager.changePassword(applicationUser, passwordDetail);
    }

    @Override
    public TelephoneDirectoryResponses valid(String password) {
        return passwordManager.isValid(password);
    }

    @Override
    public TelephoneDirectoryResponses match(PasswordDetail passwordDetail, ApplicationUser applicationUser) {
        return passwordManager.match(passwordDetail, applicationUser);
    }
}
