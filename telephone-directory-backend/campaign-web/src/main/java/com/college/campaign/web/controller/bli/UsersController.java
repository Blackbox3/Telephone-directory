package com.college.campaign.web.controller.bli;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.log.SkipAPILogging;
import com.college.campaign.common.util.ResponseBuilder;
import com.college.campaign.repository.Util.SearchQueryParameter;
import com.college.campaign.web.config.provider.LoginProvider;
import com.college.campaign.web.dto.request.StatusRequest;
import com.college.campaign.web.password.dto.ForgotPasswordRequest;
import com.college.campaign.web.users.UserService;
import com.college.campaign.web.users.dto.request.CreateUserRequest;
import com.college.campaign.web.users.dto.request.ModifyUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserService userService;

    @SkipAPILogging
    @GetMapping(value = "token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userProfileByToken() {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.getUserById(LoginProvider.getApplicationUser().getId());
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@NotNull @Valid @RequestBody CreateUserRequest createUserRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.createUser(createUserRequest);
        return ResponseBuilder.message(telephoneDirectoryResponses);
    }

    @PostMapping(value = "search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCampaignList(@NotNull @Valid @RequestBody SearchQueryParameter searchQueryParameter) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.searchUser(searchQueryParameter);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @SkipAPILogging
    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getActiveUsers() {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.getActiveUsers();
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @SkipAPILogging
    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long applicationUserId) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.getUserById(applicationUserId);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @PostMapping(value = "modify/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyUser(@PathVariable("userId") Long applicationUserId, @NotNull @Valid @RequestBody ModifyUserRequest modifyUserRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.modifyUser(modifyUserRequest, applicationUserId);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PostMapping(value = "password/reset", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> password(@NotNull @Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.forgotPassword(forgotPasswordRequest);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PostMapping(value = "status/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyStatus(@PathVariable("userId") Long applicationUserId, @NotNull @Valid @RequestBody StatusRequest statusRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.modifyStatus(applicationUserId, statusRequest);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @SkipAPILogging
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUser() {
        TelephoneDirectoryResponses telephoneDirectoryResponses = userService.getAllUser();
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }
}
