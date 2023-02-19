package com.college.campaign.common.manager;

import com.college.campaign.common.cbs.dto.CbsQueryParameter;
import com.college.campaign.common.cbs.dto.CustomRedeemDTO;
import com.college.campaign.common.manager.inquiry.CustomEnquiryContext;
import com.college.campaign.common.mapper.CustomCbsQueryParameterMapper;
import com.college.campaign.entities.model.Campaign;
import com.college.campaign.entities.model.CustomCBSQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
public class CustomQueryManager {

    @Autowired
    private CustomEnquiryContext enquiryContext;

    public List<CustomRedeemDTO> getCustomRedeemDetail(Campaign campaign, Long trackId) {
        CustomCBSQuery cbsQuery = campaign.getEventAttribute().getCustomCbsQuery();
        CbsQueryParameter cbsQueryParameter = CustomCbsQueryParameterMapper.convertToCustomCbsQueryParameter(cbsQuery);
        Map<String, Object> queryParameter = new HashMap<>();
        queryParameter.put("startDate", String.valueOf(campaign.getStartDate()));
        queryParameter.put("endDate", String.valueOf(campaign.getEndDate()));
        queryParameter.put("trackId", String.valueOf(trackId));
        return enquiryContext.customRedeemDetail(cbsQueryParameter, queryParameter);
    }
}
