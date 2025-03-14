package com.visa.applicationregistry.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "visa_application")
public class VisaApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private VisaType visaType;

    @Enumerated(EnumType.STRING)
    private SubCategory subCategory;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    private LocalDateTime submissionDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "visaApplication", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VisaApplicationDetails visaApplicationDetails;

    public VisaApplication(Long applicationId, Long userId, VisaType visaType, SubCategory subCategory, ApplicationStatus status, LocalDateTime submissionDate, PaymentStatus paymentStatus, Payment payment, VisaApplicationDetails visaApplicationDetails) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.visaType = visaType;
        this.subCategory = subCategory;
        this.status = status;
        this.submissionDate = submissionDate;
        this.paymentStatus = paymentStatus;
        this.payment = payment;
        this.visaApplicationDetails = visaApplicationDetails;
    }

    public VisaApplication() {
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

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public VisaApplicationDetails getVisaApplicationDetails() {
        return visaApplicationDetails;
    }

    public void setVisaApplicationDetails(VisaApplicationDetails visaApplicationDetails) {
        this.visaApplicationDetails = visaApplicationDetails;
    }
}