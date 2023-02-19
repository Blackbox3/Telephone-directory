package com.college.campaign.repository;

import com.college.campaign.entities.model.OfferTransaction;
import com.college.campaign.repository.custom.OfferTransactionCustom;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OfferTransactionRepository extends BaseRepository<OfferTransaction>, OfferTransactionCustom {

    @Query("select t from OfferTransaction t order by t.id desc")
    List<OfferTransaction> getAllOfferList();

    @Query("select t from OfferTransaction  t where t.campaign.campaignMode = 'MANUAL' and t.transactionStatus = 'PENDING' and t.status = 'ACTIVE'")
    List<OfferTransaction> getAllManualOfferTransactions();

    @Query("select t from OfferTransaction t where t.campaign.id =:campaignId order by t.id desc")
    List<OfferTransaction> getOfferTransactionByCampaignId(Long campaignId);
}
