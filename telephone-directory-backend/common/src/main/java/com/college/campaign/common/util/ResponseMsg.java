package com.college.campaign.common.util;


import com.college.campaign.common.dto.Message;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.dto.UnauthorizedResponse;

import java.util.Map;

public class ResponseMsg {

    public static TelephoneDirectoryResponses successResponse(String messageKey) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey);
    }

    public static TelephoneDirectoryResponses successResponse(String messageKey, Object ojb) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setObj(ojb);
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey);
    }

    public static TelephoneDirectoryResponses failureResponse(String messageKey) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setCode("2");
        telephoneDirectoryResponses.setSuccess(false);
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey);
    }

    public static TelephoneDirectoryResponses failureResponse(String messageKey, String respCode) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(false);
        telephoneDirectoryResponses.setCode(respCode);
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey);
    }

    public static UnauthorizedResponse unauthorizedResponse(String messageKey) {
        Message message = MessageComposer.compose(messageKey);

        UnauthorizedResponse unauthorizedResponse = new UnauthorizedResponse();
        unauthorizedResponse.setSuccess(false);
        unauthorizedResponse.setSessionTimeout("Y");
        unauthorizedResponse.setMessage(message.getMessage());
        return unauthorizedResponse;
    }

    public static TelephoneDirectoryResponses failureResponse(String messageKey, Map<String, String> parameters) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(false);
        telephoneDirectoryResponses.setCode("2");
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey, parameters);
    }

    public static TelephoneDirectoryResponses successResponse(String messageKey, Map<String, String> parameters) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        return MessageComposer.compose(telephoneDirectoryResponses, messageKey, parameters);
    }
}
