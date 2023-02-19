package com.college.campaign.web.crud.service;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.dto.request.StatusRequest;

public interface ServiceCrudService {

    TelephoneDirectoryResponses getService();

    TelephoneDirectoryResponses getServiceById(Long id);

    TelephoneDirectoryResponses modifyService(Long id, ServiceRequest serviceRequest);

    TelephoneDirectoryResponses createService(ServiceRequest serviceRequest);

    TelephoneDirectoryResponses modifyStatus(Long id, StatusRequest statusRequest);
}
