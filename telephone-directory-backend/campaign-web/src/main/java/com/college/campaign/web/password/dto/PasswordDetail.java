package com.college.campaign.web.password.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PasswordDetail extends ModelBase {

    private boolean allowOldPassword = true;
    /**
     * new or current password.
     */
    private String password;
    private String oldPassword;

}