package com.scisw.phonecontacts.service;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.dto.ContactDto;

public interface ContactService {
    Contact createContact(ContactDto contactDto);
}
