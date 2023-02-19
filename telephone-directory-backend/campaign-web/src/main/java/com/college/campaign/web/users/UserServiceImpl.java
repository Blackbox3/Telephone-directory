package com.college.campaign.web.users;

import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.dto.PageResponse;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.exception.DataNotFoundException;
import com.college.campaign.common.util.ResponseMsg;
import com.college.campaign.entities.model.AdminType;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.repository.AdminTypeRepository;
import com.college.campaign.repository.ApplicationUserRepository;
import com.college.campaign.repository.Util.SearchQueryParameter;
import com.college.campaign.web.dto.request.StatusRequest;
import com.college.campaign.web.password.PasswordService;
import com.college.campaign.web.password.dto.ForgotPasswordRequest;
import com.college.campaign.web.password.dto.PasswordDetail;
import com.college.campaign.web.users.dto.request.CreateUserRequest;
import com.college.campaign.web.users.dto.request.ModifyUserRequest;
import com.college.campaign.web.users.dto.response.UserListResponse;
import com.college.campaign.web.users.dto.response.UserResponse;
import com.college.campaign.web.users.manager.UserManager;
import com.college.campaign.web.users.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserManager userManager;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private AdminTypeRepository adminTypeRepository;


    @Override
    public TelephoneDirectoryResponses createUser(CreateUserRequest createUserRequest) {
         AdminType admin = adminTypeRepository.findById(1l).get();

        userManager.checkIfUsernameExist(createUserRequest.getUserName());
        TelephoneDirectoryResponses telephoneDirectoryResponses = passwordService.valid(createUserRequest.getPassword());
        if (telephoneDirectoryResponses.isSuccess()) {

            ApplicationUser applicationUser = userMapper.convertToCreateUser(createUserRequest);
            applicationUser.setAdminType(admin);
            applicationUser.setPassword(BCrypt.hashpw(createUserRequest.getPassword(), BCrypt.gensalt()));

            applicationUserRepository.save(applicationUser);
            return ResponseMsg.successResponse(MsgConstant.Data.CREATE_SUCCESS);
        }
        return telephoneDirectoryResponses;
    }

    @Override
    public TelephoneDirectoryResponses getActiveUsers() {
        UserListResponse userListResponse = new UserListResponse();
        List<UserResponse> userResponses = applicationUserRepository.getAllUser()
                .stream()
                .map(user ->
                        UserMapper.convertToUserResponse(user)
                ).collect(Collectors.toList());
        userListResponse.setUserList(userResponses);

        return ResponseMsg.successResponse(MsgConstant.Data.SUCCESS, userListResponse);
    }

    @Override
    public TelephoneDirectoryResponses getUserById(Long applicationUserId) {
        Optional<ApplicationUser> optionalApplicationUser = applicationUserRepository.findById(applicationUserId);
        if (optionalApplicationUser.isPresent()) {
            ApplicationUser applicationUser = optionalApplicationUser.get();

            UserResponse userResponse = UserMapper.convertToUserResponse(applicationUser);

            return ResponseMsg.successResponse(MsgConstant.Data.SUCCESS, userResponse);
        }
        throw new DataNotFoundException(ResponseMsg.failureResponse(MsgConstant.Data.NOT_FOUND));
    }

    @Override
    public TelephoneDirectoryResponses modifyUser(ModifyUserRequest modifyUserRequest, Long applicationUserId) {

        Optional<ApplicationUser> optionalApplicationUser = applicationUserRepository.findById(applicationUserId);
        if (optionalApplicationUser.isPresent()) {
            log.info("Application User Modify for id : " + optionalApplicationUser.get().getId());

            ApplicationUser applicationUser = userMapper.convertToModifyUser(optionalApplicationUser.get(), modifyUserRequest);
            applicationUserRepository.save(applicationUser);

            UserResponse userResponse = UserMapper.convertToUserResponse(applicationUser);
            return ResponseMsg.successResponse(MsgConstant.Data.MODIFY_SUCCESS, userResponse);
        }
        throw new DataNotFoundException(ResponseMsg.failureResponse(MsgConstant.Data.NOT_FOUND));
    }

    @Override
    public TelephoneDirectoryResponses forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        Optional<ApplicationUser> optionalApplicationUser = applicationUserRepository.findById(forgotPasswordRequest.getUserId());
        if (optionalApplicationUser.isPresent()) {
            PasswordDetail passwordDetail = new PasswordDetail();
            passwordDetail.setOldPassword(optionalApplicationUser.get().getPassword());
            passwordDetail.setPassword(forgotPasswordRequest.getNewPassword());

            return passwordService.save(passwordDetail, optionalApplicationUser.get());
        }
        throw new DataNotFoundException(ResponseMsg.failureResponse(MsgConstant.Data.NOT_FOUND));
    }

    @Override
    public TelephoneDirectoryResponses searchUser(SearchQueryParameter searchQueryParameter) {

        Page<ApplicationUser> applicationUsers = applicationUserRepository
                .findAll(applicationUserRepository.searchQuery(searchQueryParameter.getSearch()),
                        PageRequest.of(searchQueryParameter.getPage(), searchQueryParameter.getSize(), Sort.Direction.DESC, "id"));

        List<UserResponse> userResponses = applicationUsers.getContent()
                .stream()
                .map(user ->
                        UserMapper.convertToUserResponse(user)
                ).collect(Collectors.toList());

        PageResponse pageResponse = new PageResponse(userResponses, applicationUsers.getTotalElements());
        return ResponseMsg.successResponse(MsgConstant.Data.SUCCESS, pageResponse);
    }

    @Override
    public TelephoneDirectoryResponses modifyStatus(Long applicationUserId, StatusRequest statusRequest) {
        Optional<ApplicationUser> optionalApplicationUser = applicationUserRepository.findById(applicationUserId);

        if (optionalApplicationUser.isPresent()) {
            ApplicationUser applicationUser = optionalApplicationUser.get();
            applicationUser.setActive(statusRequest.getActive());
            applicationUserRepository.save(applicationUser);

            UserResponse userResponse = UserMapper.convertToUserResponse(applicationUser);
            return ResponseMsg.successResponse(MsgConstant.Data.STATUS_CHANGE_SUCCESS, userResponse);
        }
        throw new DataNotFoundException(ResponseMsg.failureResponse(MsgConstant.Data.NOT_FOUND));
    }

    @Override
    public TelephoneDirectoryResponses getAllUser() {
        UserListResponse userListResponse = new UserListResponse();
        List<UserResponse> userResponses = applicationUserRepository.findAll()
                .stream()
                .map(user ->
                        UserMapper.convertToUserResponse(user)
                ).collect(Collectors.toList());
        userListResponse.setUserList(userResponses);

        return ResponseMsg.successResponse(MsgConstant.Data.SUCCESS, userListResponse);
    }
}
