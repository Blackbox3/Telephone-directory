package com.college.campaign.common.util;

import com.college.campaign.common.dto.BaseResponse;
import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/*
 * @Author Rashim Dhaubanjar
 */
public class ResponseBuilder {

    public final static ResponseEntity<?> successObject(Object obj) {
        return new ResponseEntity<>(CommonMapper.convertToGenericResponse(obj), HttpStatus.OK);
    }

    public final static ResponseEntity<?> response(TelephoneDirectoryResponses telephoneDirectoryResponses) {
        if (telephoneDirectoryResponses.isSuccess()) {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(telephoneDirectoryResponses), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(telephoneDirectoryResponses), HttpStatus.OK);
        }
    }


    public final static ResponseEntity<?> message(TelephoneDirectoryResponses telephoneDirectoryResponses) {
        if (telephoneDirectoryResponses.isSuccess()) {
            return new ResponseEntity<>(CommonMapper.convertToMessageGenericResponse(telephoneDirectoryResponses), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CommonMapper.convertToMessageGenericResponse(telephoneDirectoryResponses), HttpStatus.OK);
        }
    }

    public final static ResponseEntity<?> mapResponse(BaseResponse baseResponse, Map<String, Object> objectMap) {
        if (baseResponse.isSuccess()) {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(baseResponse, objectMap), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CommonMapper.convertToGenericResponse(baseResponse), HttpStatus.OK);
        }
    }
}
