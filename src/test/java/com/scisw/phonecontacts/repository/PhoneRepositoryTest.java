package com.scisw.phonecontacts.repository;


import com.scisw.phonecontacts.domain.Email;
import com.scisw.phonecontacts.domain.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PhoneRepositoryTest {
    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    @Order(1)
    public void EmailRepositorySaveAndReturn() {
        Phone phone = new Phone();
        phone.setPhoneNumber("38000000000");

        Phone savedPhone = phoneRepository.save(phone);
        Assertions.assertNotNull(savedPhone);
        Assertions.assertTrue(savedPhone.getId() > 0);
    }

    @Test
    @Order(2)
    public void EmailRepositorySaveAndReturnById() {
        Phone phone = new Phone();
        phone.setPhoneNumber("38000000000");

        long id = phoneRepository.save(phone).getId();
        Phone savedPhone = phoneRepository.getReferenceById(id);
        Assertions.assertNotNull(savedPhone);
        Assertions.assertTrue(savedPhone.getId() > 0);
    }

    @Test
    @Order(3)
    public void EmailRepositoryThrowExceptionByIncorrectId() {
        Assertions.assertTrue(phoneRepository.findById(1L).isEmpty());
    }

}
