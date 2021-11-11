package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Payment;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.PaymentRepository;
import com.example.jobagapi.domain.repository.UserRepository;
import com.example.jobagapi.domain.service.PaymentService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Page<Payment> getAllPayments(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(()->new ResourceNotFoundException("Payment","Id",paymentId));
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public ResponseEntity<?> deletePayment(Long paymentId) {
        Payment payment=paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "Id", paymentId));
        paymentRepository.delete(payment);
        return ResponseEntity.ok().build();
    }
}
