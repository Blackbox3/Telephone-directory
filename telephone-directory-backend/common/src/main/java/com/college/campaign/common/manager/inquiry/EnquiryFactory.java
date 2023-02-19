package com.college.campaign.common.manager.inquiry;


import com.college.campaign.common.config.application.SystemConfig;
import com.college.campaign.common.config.constant.AdminConfigConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class EnquiryFactory {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    @Qualifier("live")
    private EnquiryManager cbsManager;

    @Autowired
    @Qualifier("local")
    private EnquiryManager localCbsManager;

    public EnquiryManager getEnquiryManager() {
        String bankWebMode = systemConfig.adminConfig(AdminConfigConstant.QUERY_MODE);
        if (bankWebMode.equalsIgnoreCase("live")) {
            return cbsManager;
        } else if (bankWebMode.equalsIgnoreCase("local")) {
            return localCbsManager;
        }
        throw new IllegalStateException();
    }
}
