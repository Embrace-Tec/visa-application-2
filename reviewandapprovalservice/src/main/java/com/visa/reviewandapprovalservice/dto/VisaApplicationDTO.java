package com.visa.reviewandapprovalservice.dto;

import java.time.LocalDateTime;

public class VisaApplicationDTO {

    private Long applicationId;
    private Long userId;
    private String visaType;
    private String subCategory;
    private String status;
    private LocalDateTime submissionDate;
    private String paymentStatus;
    private PaymentDTO payment;

    public VisaApplicationDTO(Long applicationId, Long userId, String visaType, String subCategory, String status, LocalDateTime submissionDate, String paymentStatus, PaymentDTO payment) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.visaType = visaType;
        this.subCategory = subCategory;
        this.status = status;
        this.submissionDate = submissionDate;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
    }

    public VisaApplicationDTO() {
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }
}
