package com.scisw.phonecontacts.dto.transformers;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.dto.ContactDto;

import java.util.stream.Collectors;

public class ContactTransformer {
    public static ContactDto convertToDto(Contact contact){
        return ContactDto.builder()
                .name(contact.getName())
                .emails(contact.getEmails().stream().map(EmailTransformer::convertToDto).collect(Collectors.toSet()))
                .phones(contact.getPhones().stream().map(PhoneTransformer::convertToDto).collect(Collectors.toSet()))
                .build();
    }

    public static Contact convertToEntity(ContactDto contactDto){
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setEmails(contactDto.getEmails().stream().map(EmailTransformer::convertToEntity).collect(Collectors.toSet()));
        contact.setPhones(contactDto.getPhones().stream().map(PhoneTransformer::convertToEntity).collect(Collectors.toSet()));
        return contact;
    }
}
