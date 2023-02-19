package com.college.campaign.repository;

import com.college.campaign.entities.model.CampaignEligibleProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CampaignEligibleProfileRepository extends BaseRepository<CampaignEligibleProfile> {

    @Query("select t from CampaignEligibleProfile t where t.active = 'Y' and t.campaign.id = :campaignId")
    List<CampaignEligibleProfile> getByCampaign(@Param("campaignId") Long campaignId);

    @Query("select t from CampaignEligibleProfile t where t.active = 'Y' and t.campaign.id = :campaignId and t.profileId = :profileId")
    Optional<CampaignEligibleProfile> getByCampaignAndProfileId(@Param("campaignId") Long campaignId, @Param("profileId") Long profileId);

}
