package com.college.campaign.repository;

import com.college.campaign.entities.model.CampaignEligibleService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CampaignEligibleServiceRepository extends BaseRepository<CampaignEligibleService> {

    @Query("select t from CampaignEligibleService t where t.active = 'Y' and t.campaign.id = :campaignId")
    List<CampaignEligibleService> getCampaignEligibleServiceByCampaign(@Param("campaignId") Long campaignId);

}
