package com.college.campaign.web.users;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.repository.Util.SearchQueryParameter;
import com.college.campaign.web.dto.request.StatusRequest;
import com.college.campaign.web.password.dto.ForgotPasswordRequest;
import com.college.campaign.web.users.dto.request.CreateUserRequest;
import com.college.campaign.web.users.dto.request.ModifyUserRequest;

public interface UserService {

    TelephoneDirectoryResponses createUser(CreateUserRequest createUserRequest);

    TelephoneDirectoryResponses getActiveUsers();

    TelephoneDirectoryResponses getUserById(Long applicationUserId);

    TelephoneDirectoryResponses modifyUser(ModifyUserRequest modifyUserRequest, Long applicationUserId);

    TelephoneDirectoryResponses forgotPassword(ForgotPasswordRequest forgotPasswordRequest);

    TelephoneDirectoryResponses searchUser(SearchQueryParameter searchQueryParameter);

    TelephoneDirectoryResponses modifyStatus(Long applicationUserId, StatusRequest statusRequest);

    TelephoneDirectoryResponses getAllUser();
}
