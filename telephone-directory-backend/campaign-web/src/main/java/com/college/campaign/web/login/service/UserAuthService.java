package com.college.campaign.web.login.service;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.login.dto.LoginRequest;

/*
 * @Author Rashim Dhaubanjar
 */
public interface UserAuthService {
    TelephoneDirectoryResponses login(LoginRequest loginRequest);
}
