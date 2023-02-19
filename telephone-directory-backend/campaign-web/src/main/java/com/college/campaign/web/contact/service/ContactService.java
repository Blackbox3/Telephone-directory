package com.college.campaign.web.contact.service;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.web.contact.dto.ContactCreateRequest;
import com.college.campaign.web.contact.dto.ContactModifyRequest;


public interface ContactService {

    TelephoneDirectoryResponses createContact(ContactCreateRequest contactCreateRequest);

    TelephoneDirectoryResponses contactDetail(Long contactId);

    TelephoneDirectoryResponses modifyContact(ContactModifyRequest contactModifyRequest);

    TelephoneDirectoryResponses getAllContact();

    TelephoneDirectoryResponses deleteContact(Long contactId);

    TelephoneDirectoryResponses searchContact(String keyword);


}
