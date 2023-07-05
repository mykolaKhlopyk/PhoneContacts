package com.scisw.phonecontacts.repository;

import com.scisw.phonecontacts.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
