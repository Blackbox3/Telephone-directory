package com.college.campaign.common.exception;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;

public class EntityNotFoundException extends ServerException {

    public EntityNotFoundException(final String message) {
        super(message);
    }

    public EntityNotFoundException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }
}
