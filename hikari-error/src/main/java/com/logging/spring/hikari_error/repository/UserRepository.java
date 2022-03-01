package com.logging.spring.hikari_error.repository;

import com.logging.spring.hikari_error.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}