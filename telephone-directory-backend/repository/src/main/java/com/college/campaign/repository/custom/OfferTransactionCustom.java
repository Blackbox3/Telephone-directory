package com.college.campaign.repository.custom;

import com.college.campaign.entities.model.OfferTransaction;
import com.college.campaign.repository.Util.FieldQueryParameter;
import com.querydsl.core.BooleanBuilder;

import java.util.List;


public interface OfferTransactionCustom {

    BooleanBuilder searchQuery(List<FieldQueryParameter> fieldQueryParameterList);

    List<OfferTransaction> getOfferTransactionsToProcessForRedeem(int recordToFetch);

}
