package com.visa.applicationregistry.service;

import com.visa.applicationregistry.dto.PaymentDTO;
import com.visa.applicationregistry.entity.Payment;

public interface PaymentService {
    Payment processPayment(PaymentDTO dto);

}
