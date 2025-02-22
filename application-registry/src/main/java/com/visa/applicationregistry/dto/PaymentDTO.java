package com.visa.applicationregistry.dto;

import com.visa.applicationregistry.entity.PaymentMethod;


public class PaymentDTO {
    private Long applicationId;
    private PaymentMethod paymentMethod;

public PaymentDTO() {
    }

    public PaymentDTO(Long applicationId, PaymentMethod paymentMethod) {
        this.applicationId = applicationId;
        this.paymentMethod = paymentMethod;
    }
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
