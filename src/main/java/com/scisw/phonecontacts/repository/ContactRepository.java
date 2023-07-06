package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findContactByName(String name);
}
