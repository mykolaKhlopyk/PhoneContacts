package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@RequiredArgsConstructor
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ContactRepositoryTest {

    private final ContactRepository contactRepository;

    @Test
    @Order(1)
    public void ContactRepositorySaveAndReturn() {
        Contact contact = new Contact();
        contact.setName("bob");

        Contact savedContact = contactRepository.save(contact);
        Assertions.assertNotNull(savedContact);
        Assertions.assertTrue(savedContact.getId() > 0);
    }

    @Test
    @Order(2)
    public void ContactRepositorySaveAndReturnById() {
        Contact contact = new Contact();
        contact.setName("bob");

        long id = contactRepository.save(contact).getId();
        Contact savedContact = contactRepository.getReferenceById(id);
        Assertions.assertNotNull(savedContact);
        Assertions.assertTrue(savedContact.getId() > 0);
    }

    @Test
    @Order(3)
    public void ContactRepositoryThrowExceptionByIncorrectId() {
        Assertions.assertTrue(contactRepository.findById(1L).isEmpty());
    }
}
