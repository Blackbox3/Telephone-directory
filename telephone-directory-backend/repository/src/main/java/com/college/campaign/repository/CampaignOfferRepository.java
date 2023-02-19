package com.college.campaign.repository;

import com.college.campaign.entities.model.CampaignOffer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CampaignOfferRepository extends BaseRepository<CampaignOffer> {

    @Query("select t from CampaignOffer  t where t.campaign.id =:campaignId")
    List<CampaignOffer> findByCampaignId(Long campaignId);
}
