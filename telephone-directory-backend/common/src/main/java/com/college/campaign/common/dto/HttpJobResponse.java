package com.college.campaign.common.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class HttpJobResponse extends ModelBase {

    private boolean success;
    private String message;
    private String code;
    private Object obj;
}
