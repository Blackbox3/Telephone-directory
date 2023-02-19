package com.college.campaign.common.exception;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import org.springframework.http.HttpStatus;


public class IllegalStateException extends ServerException {

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_ACCEPTABLE;
    }

    public IllegalStateException(final String message) {
        super(message);
    }

    public IllegalStateException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }
}
