package com.college.campaign.web.constant.campaign.helper;

import com.college.campaign.common.constant.MsgConstant;
import com.college.campaign.common.exception.InvalidDataException;
import com.college.campaign.common.util.DateFormat;
import com.college.campaign.common.util.DateFormatter;
import com.college.campaign.common.util.ResponseMsg;
import com.college.campaign.repository.Util.FieldQueryParameter;
import com.college.campaign.repository.Util.SearchQueryParameter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReportHelper {

    public static List<FieldQueryParameter> getQueryParameterListForReportFilter(SearchQueryParameter searchQueryParameter) {

        List<FieldQueryParameter> fieldQueryParameterList = searchQueryParameter.getSearch();
        if (fieldQueryParameterList == null) {
            fieldQueryParameterList = new ArrayList<>();
        }

        if (!StringUtils.isEmpty(searchQueryParameter.getFromDate())
                && !StringUtils.isEmpty(searchQueryParameter.getToDate())) {
            if (searchQueryParameter.getFromDate().equals(searchQueryParameter.getToDate()) && !searchQueryParameter.getFromDate().equals(DateFormatter.convertToString(new Date(), DateFormat.SQL_DATE_FORMAT))) {
                throw new InvalidDataException(ResponseMsg.failureResponse(MsgConstant.Date.INVALID_DATE));
            }
        }

        if (!StringUtils.isEmpty(searchQueryParameter.getFromDate())) {
            fieldQueryParameterList.add(new FieldQueryParameter("fromDate", DateFormatter.changeFormat
                    (DateFormatter.changeToStartDate(DateFormatter.convertToDate(searchQueryParameter.getFromDate())))));
        }
        if (!StringUtils.isEmpty(searchQueryParameter.getToDate())) {
            fieldQueryParameterList.add(new FieldQueryParameter("toDate", DateFormatter.changeFormat(
                    DateFormatter.changeToEndDate(DateFormatter.convertToDate(searchQueryParameter.getToDate())))));
        }
        return fieldQueryParameterList;
    }
}
