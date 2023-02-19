package com.college.campaign.repository.Util;

import java.util.ArrayList;
import java.util.List;


public class QueryParameterMapper {

    public static List<FieldQueryParameter> getQueryParameterListForFilter(String status) {
        List<FieldQueryParameter> fieldQueryParameterList = new ArrayList<>();
        fieldQueryParameterList.add(new FieldQueryParameter("status", status));
        return fieldQueryParameterList;
    }
}
