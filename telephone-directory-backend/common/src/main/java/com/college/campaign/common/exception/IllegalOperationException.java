package com.college.campaign.common.exception;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;

public class IllegalOperationException extends ServerException {

    public IllegalOperationException(final String message) {
        super(message);
    }

    public IllegalOperationException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }
}
