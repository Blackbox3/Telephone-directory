package com.college.campaign.web.dto;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MenuDTO extends ModelBase {

    private Long id;
    private String name;
    private String description;
    private String code;
    private String adminMenuGroupName;

}
