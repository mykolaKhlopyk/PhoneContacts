package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Email;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmailRepositoryTest {
    @Autowired
    private EmailRepository emailRepository;

    @Test
    @Order(1)
    public void EmailRepositorySaveAndReturn() {
        Email email = new Email();
        email.setEmailAddress("bob@gmail.com");

        Email savedEmail = emailRepository.save(email);
        Assertions.assertNotNull(savedEmail);
        Assertions.assertTrue(savedEmail.getId() > 0);
    }

    @Test
    @Order(2)
    public void EmailRepositorySaveAndReturnById() {
        Email email = new Email();
        email.setEmailAddress("bob@gmail.com");

        long id = emailRepository.save(email).getId();
        Email savedEmail = emailRepository.getReferenceById(id);
        Assertions.assertNotNull(savedEmail);
        Assertions.assertTrue(savedEmail.getId() > 0);
    }

    @Test
    @Order(3)
    public void EmailRepositoryThrowExceptionByIncorrectId() {
        Assertions.assertTrue(emailRepository.findById(1L).isEmpty());
    }

}
