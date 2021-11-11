package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Payment;
import com.example.jobagapi.domain.service.EmployeerService;
import com.example.jobagapi.domain.service.PaymentService;
import com.example.jobagapi.resource.EmployeerResource;
import com.example.jobagapi.resource.PaymentResource;
import com.example.jobagapi.resource.SaveEmployeerResource;
import com.example.jobagapi.resource.SavePaymentResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ModelMapper mapper;



    @Operation(summary="Get Payments", description="Get All Payments", tags={"payments"})
    @GetMapping("/payments")
    public Page<PaymentResource> getAllPayment(Pageable pageable){
        Page<Payment> paymentPage = paymentService.getAllPayments(pageable);
        List<PaymentResource> resources = paymentPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Post Payments", description="Create Payments", tags={"payments"})
    @PostMapping("/payments")
    public PaymentResource createPayment(@Valid @RequestBody SavePaymentResource resource) {
        Payment payment = convertToEntity(resource);
        return convertToResource(paymentService.createPayment(payment));
    }

    @Operation(summary="Get PaymentsById", description="Get PaymentsById", tags={"payments"})
    @GetMapping("/payments/{id}")
    public PaymentResource getPaymentById(@PathVariable(name = "id") Long paymentId) {
        return convertToResource(paymentService.getPaymentById(paymentId));
    }


    @Operation(summary="Delete Payment By Id", description="DeletePaymentById", tags={"payments"})
    @DeleteMapping("/payments/{postId}")
    public ResponseEntity<?> deletePayment(@PathVariable Long postId) {
        return paymentService.deletePayment(postId);
    }

    private Payment convertToEntity(SavePaymentResource resource) {
        return mapper.map(resource, Payment.class);
    }
    private PaymentResource convertToResource(Payment entity)
    {
        return mapper.map(entity, PaymentResource.class);
    }



}

