package com.college.campaign.common.exception;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;

public class ResourceAlreadyExistException extends ServerException {

    public ResourceAlreadyExistException(final String message) {
        super(message);
    }

    public ResourceAlreadyExistException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }
}
