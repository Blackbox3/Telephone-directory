package com.college.campaign.repository.custom;

import com.college.campaign.repository.Util.FieldQueryParameter;
import com.querydsl.core.BooleanBuilder;

import java.util.List;

public interface CBSQueryCustom {

    BooleanBuilder searchCBSQuery(List<FieldQueryParameter> fieldQueryParameterList);
}
