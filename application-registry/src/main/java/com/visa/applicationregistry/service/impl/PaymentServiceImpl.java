package com.visa.applicationregistry.service.impl;

import com.visa.applicationregistry.dto.PaymentDTO;
import com.visa.applicationregistry.entity.Payment;
import com.visa.applicationregistry.entity.PaymentStatus;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.repository.PaymentRepository;
import com.visa.applicationregistry.repository.VisaApplicationRepository;
import com.visa.applicationregistry.service.PaymentService;
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final VisaApplicationRepository visaApplicationRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              VisaApplicationRepository visaApplicationRepository) {
        this.paymentRepository = paymentRepository;
        this.visaApplicationRepository = visaApplicationRepository;
    }

    @Override
    public Payment processPayment(PaymentDTO dto) {
        VisaApplication application = visaApplicationRepository.findById(dto.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));

        Payment payment = new Payment();
        payment.setApplication(application);
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentStatus(PaymentStatus.PAID);
        application.setPaymentStatus(PaymentStatus.PAID);

        visaApplicationRepository.save(application);
        return paymentRepository.save(payment);
    }
}
