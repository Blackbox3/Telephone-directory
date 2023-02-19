package com.college.campaign.web.password;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.web.password.dto.ChangePasswordRequest;
import com.college.campaign.web.password.dto.PasswordDetail;



public interface PasswordService {

    TelephoneDirectoryResponses save(PasswordDetail passwordDetail, ApplicationUser applicationUser);

    TelephoneDirectoryResponses changePassword(ApplicationUser applicationUser, ChangePasswordRequest changePasswordRequest);

    TelephoneDirectoryResponses valid(String password);

    TelephoneDirectoryResponses match(PasswordDetail passwordDetail, ApplicationUser applicationUser);

}
