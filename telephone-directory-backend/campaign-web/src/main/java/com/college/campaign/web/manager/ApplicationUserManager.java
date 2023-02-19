package com.college.campaign.web.manager;


import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.exception.UnauthorizedException;
import com.college.campaign.entities.model.ApplicationUser;
import com.college.campaign.repository.ApplicationUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
 * @Author Rashim Dhaubanjar
 */
@Slf4j
@Component
public class ApplicationUserManager {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Transactional(readOnly = true)
    public ApplicationUser loadUserByUsername(String userName) {
        Optional<ApplicationUser> user = applicationUserRepository.findApplicationUserByUsername(userName);
        if (user.isPresent()) {
            //valid username
            log.debug("Logged in application user : {}", user.get());
            return user.get();
        }
        throw new UnauthorizedException(MsgConstant.INVALID_USERNAME_PASSWORD);
    }

}
