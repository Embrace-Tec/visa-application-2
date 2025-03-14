package com.visa.reviewandapprovalservice.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long paymentId;
    private Long applicationId;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime transactionDate;

    public PaymentDTO(Long paymentId, Long applicationId, String paymentMethod, String paymentStatus, LocalDateTime transactionDate) {
        this.paymentId = paymentId;
        this.applicationId = applicationId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.transactionDate = transactionDate;
    }

    public PaymentDTO() {
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}