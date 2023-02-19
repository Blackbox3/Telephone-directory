package com.college.campaign.repository.custom.impl;


import com.college.campaign.entities.model.QCustomCBSConnection;
import com.college.campaign.repository.Util.FieldQueryParameter;
import com.college.campaign.repository.Util.QueryMapper;
import com.college.campaign.repository.Util.SearchField;
import com.college.campaign.repository.Util.SearchParameter;
import com.college.campaign.repository.custom.CustomCBSConnectionCustom;
import com.college.campaign.repository.querydsl.AbstractQueryDslBuilder;
import com.google.common.collect.ImmutableMap;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class CustomCbsConnectionRepositoryImpl extends AbstractQueryDslBuilder implements CustomCBSConnectionCustom {

    QCustomCBSConnection customCBSConnection =QCustomCBSConnection.customCBSConnection;

    @PersistenceContext
    private EntityManager em;

    protected Map<String, SearchField> searchCBSConnection = ImmutableMap.<String,SearchField>builder()
            .put("active", new SearchField(customCBSConnection.active, "::", "&&"))
            .build();

    @Override
    public BooleanBuilder searchCBSConnection(List<FieldQueryParameter> fieldQueryParameterList) {
        List<SearchParameter> searchParameterList = QueryMapper.convertToSearchParameterList(fieldQueryParameterList,searchCBSConnection);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        return buildWhereClause(searchParameterList,booleanBuilder);
    }
}
