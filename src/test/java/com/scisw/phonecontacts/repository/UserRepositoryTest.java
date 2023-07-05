package com.scisw.phonecontacts.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.scisw.phonecontacts.domain.User;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @Order(1)
    public void UserRepositorySaveAndReturn(){
        User user = new User();
        user.setLogin("bob");
        user.setPassword("1111");

        User savedUser = userRepository.save(user);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId()>0);
    }

    @Test
    @Order(2)
    public void UserRepositorySaveAndReturnById(){
        User user = new User();
        user.setLogin("bob");
        user.setPassword("1111");

        long id = userRepository.save(user).getId();
        User savedUser = userRepository.getReferenceById(id);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getId()>0);
    }

    @Test
    @Order(3)
    public void EmailRepositoryThrowExceptionByIncorrectId() {
        Assertions.assertTrue(userRepository.findById(1L).isEmpty());
    }

}
