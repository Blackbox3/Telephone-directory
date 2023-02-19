package com.college.campaign.common.exception;


import com.college.campaign.common.dto.TelephoneDirectoryResponses;

public class InvalidDataException extends ServerException {

    public InvalidDataException(final String message) {
        super(message);
    }

    public InvalidDataException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        super(telephoneDirectoryResponses);
    }
}
