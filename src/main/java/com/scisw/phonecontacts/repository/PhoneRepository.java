package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Optional<Phone> findByPhoneNumber(String phoneNumber);
}
