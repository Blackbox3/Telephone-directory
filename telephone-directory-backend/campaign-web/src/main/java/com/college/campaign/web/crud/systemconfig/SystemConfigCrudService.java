package com.college.campaign.web.crud.systemconfig;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.dto.request.StatusRequest;

public interface SystemConfigCrudService {

    TelephoneDirectoryResponses getSystemConfig();

    TelephoneDirectoryResponses getSystemConfigId(Integer id);

    TelephoneDirectoryResponses modifySystemConfig(Integer id, SystemConfigRequest systemConfigRequest);

    TelephoneDirectoryResponses createSystemConfig(SystemConfigRequest systemConfigRequest);

    TelephoneDirectoryResponses modifyStatus(Integer id, StatusRequest statusRequest);
}
