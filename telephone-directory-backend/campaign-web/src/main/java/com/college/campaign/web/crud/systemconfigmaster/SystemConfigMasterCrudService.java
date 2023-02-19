package com.college.campaign.web.crud.systemconfigmaster;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.dto.request.StatusRequest;

public interface SystemConfigMasterCrudService {

    TelephoneDirectoryResponses createSystemConfigMaster(SystemConfigMasterRequest systemConfigMasterRequest);

    TelephoneDirectoryResponses getSystemConfigMaster();

    TelephoneDirectoryResponses getSystemConfigMasterById(Integer id);

    TelephoneDirectoryResponses modifySystemConfigMaster(Integer id, SystemConfigMasterRequest systemConfigMasterRequest);

    TelephoneDirectoryResponses modifyStatus(Integer id, StatusRequest statusRequest);
}
