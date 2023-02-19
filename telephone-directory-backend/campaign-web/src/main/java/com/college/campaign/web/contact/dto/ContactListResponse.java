package com.college.campaign.web.contact.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ContactListResponse {

    private List<ContactResponseDto> contactList;
}
