package com.college.campaign.web.login;


import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.exception.UnauthorizedException;
import com.college.campaign.entities.model.AdminRolesProfile;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.repository.AdminRolesProfileRepository;
import com.college.campaign.web.auth.AuthenticationRequest;
import com.college.campaign.web.auth.TokenUtil;
import com.college.campaign.web.dto.MenuDTO;
import com.college.campaign.web.login.dto.LoginResponse;
import com.college.campaign.web.manager.ApplicationUserManager;
import com.college.campaign.web.mapper.MenuMapper;
import com.college.campaign.web.token.TokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author Rashim Dhaubanjar
 */
@Slf4j
@Component
@RequestScope
public class Login {
    @Autowired
    protected ApplicationUserManager applicationUserManager;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private TokenHelper tokenHelper;
    @Autowired
    private AdminRolesProfileRepository adminRolesProfileRepository;

    protected ApplicationUser applicationUser;
    protected AuthenticationRequest authenticationRequest;
    protected TelephoneDirectoryResponses telephoneDirectoryResponses;

    private void init(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }


    public TelephoneDirectoryResponses authenticate(AuthenticationRequest authenticationRequest) {
        telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        applicationUser = applicationUserManager.loadUserByUsername(authenticationRequest.getUsername());

        init(authenticationRequest);

        telephoneDirectoryResponses = authenticate();

        return telephoneDirectoryResponses;
    }


    private TelephoneDirectoryResponses authenticate() {
        LoginResponse loginResponse = new LoginResponse();
        if (applicationUser.getActive() == 'Y') {
            validateCredential();
            List<AdminRolesProfile> adminRolesProfileList = adminRolesProfileRepository.loadAllActiveRolesByAdminType(applicationUser.getAdminType().getId());
            loginResponse.setUsername(applicationUser.getUsername());
            loginResponse.setName(applicationUser.getName());
            loginResponse.setEmailAddress(applicationUser.getEmailAddress());
            loginResponse.setType(applicationUser.getAdminTypeName());
            loginResponse.setRoles(convertToAdminRoles(adminRolesProfileList));

            String token = generateToken(applicationUser);
            tokenHelper.createToken(token, applicationUser.getUsername());
            loginResponse.setToken(token);
            telephoneDirectoryResponses.setSuccess(true);
            telephoneDirectoryResponses.setObj(loginResponse);
            return telephoneDirectoryResponses;

        } else {
            throw new UnauthorizedException(MsgConstant.Admin.LOGIN_BLOCKED);
        }
    }

    public TelephoneDirectoryResponses validateCredential() {
        boolean valid = bcrypt.matches(authenticationRequest.getPassword(), applicationUser.getPassword());

        if (valid) {
            telephoneDirectoryResponses.setSuccess(true);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(applicationUser, null));
            return telephoneDirectoryResponses;
        } else {
            throw new UnauthorizedException(MsgConstant.INVALID_USERNAME_PASSWORD);
        }
    }

    public String generateToken(ApplicationUser applicationUser) {
        return tokenUtil.generateToken(applicationUser.getUsername(), "WEB");
    }

    private List<MenuDTO> convertToAdminRoles(List<AdminRolesProfile> adminRolesProfileList) {
        List<MenuDTO> menuDTOList = adminRolesProfileList.stream()
                .filter(adminRoles -> adminRoles.getAdminMenu().getActive() == 'Y')
                .map(adminRoles -> MenuMapper.convertToMenuDTO(adminRoles.getAdminMenu()))
                .collect(Collectors.toList());
        return menuDTOList;
    }
}
