package com.visa.applicationregistry.controller;


import com.visa.applicationregistry.dto.PaymentDTO;
import com.visa.applicationregistry.entity.Payment;
import com.visa.applicationregistry.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment processPayment(@RequestBody PaymentDTO dto) {
        return service.processPayment(dto);
    }
}
