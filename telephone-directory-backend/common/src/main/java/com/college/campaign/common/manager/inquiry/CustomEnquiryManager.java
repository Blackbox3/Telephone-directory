package com.college.campaign.common.manager.inquiry;


import com.college.campaign.common.cbs.dto.*;

import java.util.List;
import java.util.Map;


public interface CustomEnquiryManager {

    List<CustomRedeemDTO> customRedeemDetail(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameter);
}
