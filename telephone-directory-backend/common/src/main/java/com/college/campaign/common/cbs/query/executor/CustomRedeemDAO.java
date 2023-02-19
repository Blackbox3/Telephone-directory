package com.college.campaign.common.cbs.query.executor;

import com.college.campaign.common.cbs.dto.CustomRedeemDTO;

import java.util.List;


public interface CustomRedeemDAO {

    List<CustomRedeemDTO> customRedeemDetail(String query);
}
