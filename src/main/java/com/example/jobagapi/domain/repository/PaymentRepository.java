package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Page<Payment> findById(Long Id, Pageable pageable); //Encontrar por Id
}
