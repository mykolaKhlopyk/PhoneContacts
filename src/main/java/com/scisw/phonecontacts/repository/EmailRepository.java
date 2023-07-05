package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
