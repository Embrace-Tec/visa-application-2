package com.visa.applicationregistry.dto;

import com.visa.applicationregistry.entity.*;
import lombok.Data;

import java.time.LocalDateTime;

public class VisaApplicationDTO {
    private Long applicationId;
    private Long userId;
    private VisaType visaType;
    private SubCategory subCategory;
    private ApplicationStatus status;
    private PaymentStatus paymentStatus;
    private LocalDateTime submissionDate;
    private PaymentMethod paymentMethod;

    public VisaApplicationDTO() {
    }

    public VisaApplicationDTO(Long applicationId, Long userId, VisaType visaType, SubCategory subCategory, ApplicationStatus status, PaymentStatus paymentStatus, LocalDateTime submissionDate, PaymentMethod paymentMethod) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.visaType = visaType;
        this.subCategory = subCategory;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.submissionDate = submissionDate;
        this.paymentMethod = paymentMethod;
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

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
