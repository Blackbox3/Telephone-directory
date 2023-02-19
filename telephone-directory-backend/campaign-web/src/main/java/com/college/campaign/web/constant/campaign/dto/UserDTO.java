package com.college.campaign.web.constant.campaign.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDTO extends ModelBase {

    private String username;
    private String promoCode;
}
