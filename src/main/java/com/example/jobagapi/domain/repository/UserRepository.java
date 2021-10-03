package com.example.jobagapi.domain.repository;


import com.example.jobagapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);
    Boolean existsByNumber(Long number);
    Optional<User> findById(Long id);
}
