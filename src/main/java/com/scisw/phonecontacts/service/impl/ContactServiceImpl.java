package com.scisw.phonecontacts.service.impl;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.transformer.ContactTransformer;
import com.scisw.phonecontacts.repository.ContactRepository;
import com.scisw.phonecontacts.repository.EmailRepository;
import com.scisw.phonecontacts.repository.PhoneRepository;
import com.scisw.phonecontacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Contact createContact(ContactDto contactDto) {
        Contact contact = ContactTransformer.convertToEntity(contactDto);
        contact.setEmails(contact.getEmails().stream()
                .map(email -> emailRepository.findByEmailAddress(email.getEmailAddress()).orElseGet(()->emailRepository.save(email)))
                .collect(Collectors.toSet()));
        contact.setPhones(contact.getPhones().stream()
                .map(phone -> phoneRepository.findByPhoneNumber(phone.getPhoneNumber()).orElseGet(()->phoneRepository.save(phone)))
                .collect(Collectors.toSet()));
        return contactRepository.save(contact);
    }
}
