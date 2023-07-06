package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {
    Optional<Email> findByEmailAddress(String emailAddress);
}
