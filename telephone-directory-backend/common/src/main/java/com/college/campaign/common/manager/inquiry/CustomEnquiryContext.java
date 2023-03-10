package com.college.campaign.common.manager.inquiry;

import com.college.campaign.common.cbs.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class CustomEnquiryContext {

    @Autowired
    private CustomEnquiryFactory enquiryFactory;

    public List<CustomRedeemDTO> customRedeemDetail(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameter) {
        return enquiryFactory.getEnquiryManager().customRedeemDetail(cbsQueryParameter, queryParameter);
    }
}
