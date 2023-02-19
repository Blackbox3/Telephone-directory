package com.college.campaign.common.util;

import com.college.campaign.common.constant.ResponseCodeConstant;
import com.college.campaign.common.dto.BaseResponse;
import com.college.campaign.common.dto.GenericResponse;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;

import java.util.Map;

/*
 * @Author Rashim Dhaubanjar
 */
public class CommonMapper {

    private CommonMapper() {
    }

    public static GenericResponse convertToGenericResponse(TelephoneDirectoryResponses telephoneDirectoryResponses) {
        GenericResponse genericResponse = new GenericResponse();
        if (telephoneDirectoryResponses.isSuccess()) {
            genericResponse.setSuccess(telephoneDirectoryResponses.isSuccess());
            genericResponse.setCode(telephoneDirectoryResponses.getCode() == null ? "0" : telephoneDirectoryResponses.getCode());
            genericResponse.setMessage(telephoneDirectoryResponses.getMessage());
            genericResponse.setData(telephoneDirectoryResponses.getObj());
        } else {
            genericResponse.setSuccess(telephoneDirectoryResponses.isSuccess());
            genericResponse.setCode(telephoneDirectoryResponses.getCode());
            genericResponse.setMessage(telephoneDirectoryResponses.getMessage());
        }
        return genericResponse;
    }

    public static <T> GenericResponse convertToGenericResponse(T data) {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccess(true);
        genericResponse.setCode(ResponseCodeConstant.SUCCESS);
        genericResponse.setData(data);
        return genericResponse;
    }

    public static GenericResponse convertToMessageGenericResponse(TelephoneDirectoryResponses telephoneDirectoryResponses) {
        GenericResponse genericResponse = new GenericResponse();
        if (telephoneDirectoryResponses.isSuccess()) {
            genericResponse.setSuccess(telephoneDirectoryResponses.isSuccess());
            genericResponse.setMessage(telephoneDirectoryResponses.getMessage());
            genericResponse.setCode(telephoneDirectoryResponses.getCode());
        } else {
            genericResponse.setSuccess(telephoneDirectoryResponses.isSuccess());
            genericResponse.setMessage(telephoneDirectoryResponses.getMessage());
            genericResponse.setCode(telephoneDirectoryResponses.getCode());
        }
        return genericResponse;
    }

    public static GenericResponse convertToGenericResponse(BaseResponse baseResponse, Map<String, Object> objectMap) {
        GenericResponse genericResponse = new GenericResponse();
        if (baseResponse.isSuccess()) {
            genericResponse.setSuccess(baseResponse.isSuccess());
            genericResponse.setMessage(baseResponse.getMessage());
            genericResponse.setData(objectMap);
            genericResponse.setCode(baseResponse.getCode());
        } else {
            genericResponse.setSuccess(baseResponse.isSuccess());
            genericResponse.setMessage(baseResponse.getMessage());
            genericResponse.setCode(baseResponse.getCode());
        }
        return genericResponse;
    }

    public static GenericResponse convertToGenericResponse(BaseResponse baseResponse) {
        GenericResponse genericResponse = new GenericResponse();
        if (baseResponse.isSuccess()) {
            genericResponse.setSuccess(baseResponse.isSuccess());
            genericResponse.setMessage(baseResponse.getMessage());
            genericResponse.setCode(baseResponse.getCode());
        } else {
            genericResponse.setSuccess(baseResponse.isSuccess());
            genericResponse.setMessage(baseResponse.getMessage());
            genericResponse.setCode(baseResponse.getCode());
        }
        return genericResponse;
    }
}
