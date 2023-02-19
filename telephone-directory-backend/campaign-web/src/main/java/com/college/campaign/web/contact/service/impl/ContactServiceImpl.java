package com.college.campaign.web.contact.service.impl;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.util.DateFormat;
import com.college.campaign.common.util.DateFormatter;
import com.college.campaign.entities.model.Contact;
import com.college.campaign.repository.ContactRepository;
import com.college.campaign.web.contact.dto.ContactCreateRequest;
import com.college.campaign.web.contact.dto.ContactListResponse;
import com.college.campaign.web.contact.dto.ContactModifyRequest;
import com.college.campaign.web.contact.dto.ContactResponseDto;
import com.college.campaign.web.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public TelephoneDirectoryResponses createContact(ContactCreateRequest contactCreateRequest) {

        Contact contact = new Contact();

        contact.setFirstName(contactCreateRequest.getFirstName());
        contact.setLastName(contactCreateRequest.getLastName());
        contact.setMobileNumber(contactCreateRequest.getMobileNumber());
        contact.setActive("Y");
        contact.setDateOfBirth(DateFormatter.convertToDate(contactCreateRequest.getDateOfBirth()));
        contact.setEmail(contactCreateRequest.getEmail());

        contactRepository.save(contact);

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setMessage("Contact Has been created Successfully");

        return telephoneDirectoryResponses;
    }

    @Override
    public TelephoneDirectoryResponses contactDetail(Long contactId) {

        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        Contact contact = optionalContact.get();

        ContactResponseDto contactResponseDto = new ContactResponseDto();
        contactResponseDto.setFirstName(contact.getFirstName());
        contactResponseDto.setLastName(contact.getLastName());
        contactResponseDto.setMobileNumber(contact.getMobileNumber());
        contactResponseDto.setDateOfBirth(DateFormatter.getDayMonthYear(DateFormatter.changeFormat(contact.getDateOfBirth(), DateFormat.SQL_DATE_FORMAT)));
        contactResponseDto.setEmail(contact.getEmail());

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setMessage("Contact Detail Fetched Successfully");
        telephoneDirectoryResponses.setObj(contactResponseDto);

        return telephoneDirectoryResponses;
    }

    @Override
    public TelephoneDirectoryResponses modifyContact(ContactModifyRequest contactModifyRequest) {
        Contact contact = contactRepository.findById(contactModifyRequest.getId()).get();

        contact.setMobileNumber(contactModifyRequest.getMobileNumber());
        contact.setFirstName(contactModifyRequest.getFirstName());
        contact.setLastName(contactModifyRequest.getLastName());

        contactRepository.save(contact);

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setMessage("Contact Has been updated Successfully");
        return telephoneDirectoryResponses;
    }

    @Override
    public TelephoneDirectoryResponses getAllContact() {
        List<Contact> contacts = contactRepository.findAll().stream()
                .filter(contact -> contact.getActive().equalsIgnoreCase("Y")).collect(Collectors.toList());
        ContactListResponse contactList = new ContactListResponse();
        List<ContactResponseDto> contactsResponses = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactResponseDto contactResponseDto = new ContactResponseDto();
            contactResponseDto.setFirstName(contact.getFirstName());
            contactResponseDto.setLastName(contact.getLastName());
            contactResponseDto.setEmail(contact.getEmail());
            contactResponseDto.setMobileNumber(contact.getMobileNumber());
            contactResponseDto.setId(contact.getId());
            if (contact.getDateOfBirth() != null) {
                contactResponseDto.setDateOfBirth(DateFormatter.getDayMonthYear(DateFormatter.changeFormat(contact.getDateOfBirth(), DateFormat.SQL_DATE_FORMAT)));
            }
            contactsResponses.add(contactResponseDto);
        }
        contactList.setContactList(contactsResponses);

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setMessage("Contact List fetched successfully");
        telephoneDirectoryResponses.setObj(contactList);
        return telephoneDirectoryResponses;
    }





    @Override
    public TelephoneDirectoryResponses deleteContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId).get();

        contact.setActive("N");
        contactRepository.save(contact);

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setMessage("Contact Deleted Successfully");
        telephoneDirectoryResponses.setCode("0");
        return telephoneDirectoryResponses;
    }

    @Override
    public TelephoneDirectoryResponses searchContact(String keyword) {
        List<Contact> contacts = contactRepository.searchContact(keyword).stream()
                .filter(contact -> contact.getActive().equalsIgnoreCase("Y")).collect(Collectors.toList());

        ContactListResponse contactList = new ContactListResponse();
        List<ContactResponseDto> contactsResponses = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactResponseDto contactResponseDto = new ContactResponseDto();
            contactResponseDto.setFirstName(contact.getFirstName());
            contactResponseDto.setLastName(contact.getLastName());
            contactResponseDto.setEmail(contact.getEmail());
            contactResponseDto.setMobileNumber(contact.getMobileNumber());
            contactResponseDto.setId(contact.getId());
            if (contact.getDateOfBirth() != null) {
                contactResponseDto.setDateOfBirth(DateFormatter.getDayMonthYear(DateFormatter.changeFormat(contact.getDateOfBirth(), DateFormat.SQL_DATE_FORMAT)));
            }
            contactsResponses.add(contactResponseDto);
        }
        contactList.setContactList(contactsResponses);

        TelephoneDirectoryResponses telephoneDirectoryResponses = new TelephoneDirectoryResponses();
        telephoneDirectoryResponses.setSuccess(true);
        telephoneDirectoryResponses.setCode("0");
        telephoneDirectoryResponses.setMessage("Contact List fetched successfully");
        telephoneDirectoryResponses.setObj(contactList);
        return telephoneDirectoryResponses;
    }

}
