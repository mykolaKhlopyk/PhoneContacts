package com.scisw.phonecontacts.service;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.dto.ContactDto;

import java.util.Set;

public interface ContactService {
    ContactDto createContact(ContactDto contactDto);

    Set<ContactDto> getAllForUser();

    ContactDto update(ContactDto contactDto);

    ContactDto deleteContact(String name);
}
