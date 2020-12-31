package com.prac.recordsmanagerweb.repositories;

import com.prac.recordsmanagerweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
