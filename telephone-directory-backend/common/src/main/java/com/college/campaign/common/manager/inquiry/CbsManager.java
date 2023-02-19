package com.college.campaign.common.manager.inquiry;

import com.college.campaign.common.cbs.dto.CbsQueryParameter;
import com.college.campaign.common.cbs.dto.CustomerDetailDTO;
import com.college.campaign.common.cbs.dto.CustomerProfileDTO;
import com.college.campaign.common.cbs.dto.TransactionDTO;
import com.college.campaign.common.cbs.factory.JdbcTemplateFactory;
import com.college.campaign.common.cbs.query.executor.*;
import com.college.campaign.common.util.QueryHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Slf4j
@Component
@Qualifier("live")
public class CbsManager implements EnquiryManager {

    @Override
    public List<CustomerProfileDTO> customerProfile(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameterMap) {
        String query = QueryHelper.convertedSql(cbsQueryParameter.getSql(), queryParameterMap);
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getCbsJdbcTemplate(cbsQueryParameter);
        ProfileDAO profileDAO = new ProfileDAOImpl(jdbcTemplate);
        return profileDAO.customerProfile(query);
    }

    @Override
    public List<CustomerDetailDTO> customerDetail(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameterMap) {
        String query = QueryHelper.convertedSql(cbsQueryParameter.getSql(), queryParameterMap);
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getCbsJdbcTemplate(cbsQueryParameter);
        CustomerDetailDAO customerDetailDAO = new CustomerDetailDAOImpl(jdbcTemplate);
        return customerDetailDAO.customerDetail(query);
    }

    @Override
    public List<TransactionDTO> campaignWithProduct(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameter) {
        String query = QueryHelper.convertedSql(cbsQueryParameter.getSql(), queryParameter);
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getCbsJdbcTemplate(cbsQueryParameter);
        CampaignTxnDetailDAO campaignTxnDetailDAO = new CampaignTxnDetailDAOImpl(jdbcTemplate);
        return campaignTxnDetailDAO.campaignTxnDetail(query);
    }

    @Override
    public List<TransactionDTO> campaignWithoutProduct(CbsQueryParameter cbsQueryParameter, Map<String, Object> queryParameter) {
        String query = QueryHelper.convertedSql(cbsQueryParameter.getSql(), queryParameter);
        JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getCbsJdbcTemplate(cbsQueryParameter);
        CampaignTxnDetailDAO campaignTxnDetailDAO = new CampaignTxnDetailDAOImpl(jdbcTemplate);
        return campaignTxnDetailDAO.campaignTxnDetailWithoutProduct(query);
    }
}
