package com.college.campaign.web.constant.campaign.dto.response;

import com.college.campaign.common.dto.ModelBase;
import com.college.campaign.web.constant.campaign.dto.CampaignDetailDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Getter
@Setter
public class CampaignDetailListResponse extends ModelBase {

    private List<CampaignDetailDTO> campaignDetails;
}
