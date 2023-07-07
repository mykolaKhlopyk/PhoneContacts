package com.scisw.phonecontacts.service.impl;

import com.scisw.phonecontacts.domain.Contact;
import com.scisw.phonecontacts.domain.Email;
import com.scisw.phonecontacts.domain.Phone;
import com.scisw.phonecontacts.domain.User;
import com.scisw.phonecontacts.dto.ContactDto;
import com.scisw.phonecontacts.dto.transformer.ContactTransformer;
import com.scisw.phonecontacts.exceptions.ContactNotExistException;
import com.scisw.phonecontacts.exceptions.IncorrectEmailOrPhoneException;
import com.scisw.phonecontacts.repository.ContactRepository;
import com.scisw.phonecontacts.repository.EmailRepository;
import com.scisw.phonecontacts.repository.PhoneRepository;
import com.scisw.phonecontacts.repository.UserRepository;
import com.scisw.phonecontacts.service.ContactService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;
    private final UserRepository userRepository;

    private final Validator validator;

    @Override
    @Transactional
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = ContactTransformer.convertToEntity(contactDto);
        contact.setOwner(getAuthenticatedUser());
        saveEmailsAndPhones(contact);
        return ContactTransformer.convertToDto(contactRepository.save(contact));
    }

    @Override
    public Set<ContactDto> getAllForUser() {
        User user = getAuthenticatedUser();
        Hibernate.initialize(user.getContacts());
        return user.getContacts().stream().map(ContactTransformer::convertToDto).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public ContactDto update(ContactDto contactDto) {
        Set<ConstraintViolation<ContactDto>> violations = validator.validate(contactDto);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<ContactDto> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
                if (!constraintViolation.getMessage().equals("Contact name already exist"))
                    throw new IncorrectEmailOrPhoneException("Error occurred: " + sb.toString());
            }
        } else {
            throw new ContactNotExistException();
        }
        Contact contact = ContactTransformer.convertToEntity(contactDto);
        Contact oldContact = contactRepository.findContactByName(contact.getName()).get();
        removeRelationsWithContacts(contact);
        saveEmailsAndPhones(contact);
        return ContactTransformer.convertToDto(oldContact);
    }

    @Override
    @Transactional
    public ContactDto deleteContact(String name) {
        Contact contactForDelete = contactRepository.findContactByName(name).orElseThrow(RuntimeException::new);
        removeRelationsWithContacts(contactForDelete);
        return ContactTransformer.convertToDto(contactForDelete);
    }

    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return userRepository.findByLogin(user.getLogin()).get();
    }

    private void saveEmailsAndPhones(Contact contact) {
        contact.setEmails(contact.getEmails().stream()
                .map(email -> emailRepository.findByEmailAddress(email.getEmailAddress()).orElseGet(() -> emailRepository.save(email)))
                .collect(Collectors.toList()));
        contact.setPhones(contact.getPhones().stream()
                .map(phone -> phoneRepository.findByPhoneNumber(phone.getPhoneNumber()).orElseGet(() -> phoneRepository.save(phone)))
                .collect(Collectors.toList()));
    }

    private void removeRelationsWithContacts(Contact contact) {
        for (Email email : contact.getEmails()) {
            email.getContacts().remove(contact);
            if (email.getContacts().isEmpty())
                emailRepository.delete(email);
        }
        for (Phone phone : contact.getPhones()) {
            phone.getContacts().remove(contact);
            if (phone.getContacts().isEmpty())
                phoneRepository.delete(phone);
        }
    }

}
