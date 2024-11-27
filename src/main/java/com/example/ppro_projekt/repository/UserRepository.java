package com.example.ppro_projekt.repository;

import com.example.ppro_projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}