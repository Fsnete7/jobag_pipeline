package com.example.jobagapi.domain.service;


import com.example.jobagapi.domain.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    Page<Payment> getAllPayments(Pageable pageable);
    Payment getPaymentById(Long paymentId);
    Payment createPayment(Payment payment);
    ResponseEntity<?> deletePayment(Long paymentId);
}
