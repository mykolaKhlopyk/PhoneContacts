package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
