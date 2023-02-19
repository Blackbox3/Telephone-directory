package com.college.campaign.web.constant.campaign.service;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.constant.campaign.dto.request.campaign.CreateCampaignRequest;
import com.college.campaign.web.constant.campaign.dto.request.campaign.ModifyCampaignRequest;
import com.college.campaign.web.constant.campaign.dto.request.campaign.UpdateCampaignStatusRequest;


public interface CampaignCrudService {

    TelephoneDirectoryResponses createCampaign(CreateCampaignRequest createCampaignRequest);

    TelephoneDirectoryResponses modifyCampaign(ModifyCampaignRequest modifyCampaignRequest);

    TelephoneDirectoryResponses updateCampaignStatus(UpdateCampaignStatusRequest updateCampaignStatusRequest);

    TelephoneDirectoryResponses delete(Long campaignId);

}
