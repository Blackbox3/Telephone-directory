package com.college.campaign.web.controller;

import com.college.campaign.common.dto.TelephoneDirectoryResponses;
import com.college.campaign.common.log.SkipAPILogging;
import com.college.campaign.common.util.ResponseBuilder;
import com.college.campaign.web.contact.dto.ContactCreateRequest;
import com.college.campaign.web.contact.dto.ContactModifyRequest;
import com.college.campaign.web.contact.dto.SearchContactRequest;
import com.college.campaign.web.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Slf4j
@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createContact(@NotNull @Valid @RequestBody ContactCreateRequest contactCreateRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.createContact(contactCreateRequest);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @SkipAPILogging
    @GetMapping(value = "{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> contactDetail(@PathVariable("contactId") Long contactId) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.contactDetail(contactId);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PostMapping(value = "modify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> modifyContact(@NotNull @Valid @RequestBody ContactModifyRequest contactModifyRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.modifyContact(contactModifyRequest);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @SkipAPILogging
    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getContactList() {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.getAllContact();
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @GetMapping(value = "delete/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteContact(@PathVariable("contactId")Long id) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.deleteContact(id);
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

    @PostMapping(value = "search",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchContact(@RequestBody SearchContactRequest searchContactRequest) {
        TelephoneDirectoryResponses telephoneDirectoryResponses = contactService.searchContact(searchContactRequest.getKeyword());
        return ResponseBuilder.response(telephoneDirectoryResponses);
    }

}
