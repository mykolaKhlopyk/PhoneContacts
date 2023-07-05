package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
