package com.eren.emlakcepteservice.repository;

import com.eren.emlakcepteservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Find User By Email
    Optional<User> findByEmail(String email);
}
