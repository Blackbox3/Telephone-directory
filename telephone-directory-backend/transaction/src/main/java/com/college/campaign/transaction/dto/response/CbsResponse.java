package com.college.campaign.transaction.dto.response;

import com.college.campaign.common.dto.ModelBase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CbsResponse<T> extends ModelBase {

    private String message;
    private String code;
    private String developerMessage;
    private String link;
    private T data;
    private HttpStatus httpStatus;
}
