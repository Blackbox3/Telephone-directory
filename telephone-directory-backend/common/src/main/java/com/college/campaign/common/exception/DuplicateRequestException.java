package com.college.campaign.common.exception;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import org.springframework.http.HttpStatus;


public class DuplicateRequestException extends ServerException {

    public DuplicateRequestException(String message) {
        super(message);
    }

    public DuplicateRequestException(TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.OK;
    }

    @Override
    public Integer getCode() {
        return 4000;
    }
}
