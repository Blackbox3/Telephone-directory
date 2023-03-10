package com.college.campaign.repository.custom.impl;

import com.college.campaign.repository.Util.FieldQueryParameter;
import com.college.campaign.repository.Util.QueryMapper;
import com.college.campaign.repository.Util.SearchField;
import com.college.campaign.repository.Util.SearchParameter;
import com.college.campaign.repository.custom.CampaignCustom;
import com.college.campaign.repository.querydsl.AbstractQueryDslBuilder;
import com.google.common.collect.ImmutableMap;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class CampaignRepositoryImpl extends AbstractQueryDslBuilder implements CampaignCustom {

    @PersistenceContext
    private EntityManager em;

    protected Map<String, SearchField> search = ImmutableMap.<String, SearchField>builder()
            .put("fromDate", new SearchField(campaign.startDate, ">", "&&"))
            .put("toDate", new SearchField(campaign.endDate, "<", "&&"))
            .put("name", new SearchField(campaign.title, "::", "&&"))
            .put("status", new SearchField(campaign.status, "==", "&&"))
            .put("stage", new SearchField(campaign.campaignMode, "==", "&&"))
            .put("eventTypeId",new SearchField(campaign.eventTypeId.id,"==","&&"))
            .build();

    @Override
    public BooleanBuilder searchQuery(List<FieldQueryParameter> fieldQueryParameterList) {
        List<SearchParameter> searchParameterList = QueryMapper.convertToSearchParameterList(fieldQueryParameterList, search);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(campaign.active.eq('Y'));
        return buildWhereClause(searchParameterList, booleanBuilder);
    }
}
