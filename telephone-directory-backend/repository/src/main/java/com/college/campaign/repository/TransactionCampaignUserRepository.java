package com.college.campaign.repository;

import com.college.campaign.entities.model.TransactionCampaignUser;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface TransactionCampaignUserRepository extends BaseRepository<TransactionCampaignUser> {

    @Query("select t from TransactionCampaignUser t where t.username =:username and t.campaign.id =:campaignId")
    Optional<TransactionCampaignUser> findByUsernameAndCampaignId(String username, Long campaignId);
}
