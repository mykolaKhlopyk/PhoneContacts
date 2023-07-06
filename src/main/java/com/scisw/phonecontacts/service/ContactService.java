package com.scisw.phonecontacts.service;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ContactService {
    Contact createContact(ContactDto contactDto);
}
