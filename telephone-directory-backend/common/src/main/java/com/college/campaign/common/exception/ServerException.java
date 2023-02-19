package com.college.campaign.common.exception;

import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.util.ResponseMsg;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerException extends RuntimeException {

    private TelephoneDirectoryResponses telephoneDirectoryResponses;

    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public Integer getCode() {
        return null;
    }

    public String getProcessingCode() {
        return null;
    }

    public ServerException() {
        super();
    }

    public ServerException(final String message) {
        super(message);
    }

    public ServerException(final TelephoneDirectoryResponses telephoneDirectoryResponses) {
        this.telephoneDirectoryResponses = telephoneDirectoryResponses;
    }

    public TelephoneDirectoryResponses getServerResponse() {
        if (telephoneDirectoryResponses == null) {
            return ResponseMsg.failureResponse(MsgConstant.INTERNAL_SERVER_ERROR);
        }
        return telephoneDirectoryResponses;
    }
}
