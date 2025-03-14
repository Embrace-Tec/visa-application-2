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

    // Fields for Visa Application Details
    private String passportId;
    private String applicantName;
    private String photoUrl;
    private String nationality;
    private String address;
    private String contactNumber;

    // Fields for Payment Details
    private PaymentDTO payment;

    // Constructors
    public VisaApplicationDTO() {
    }

    public VisaApplicationDTO(Long applicationId, Long userId, VisaType visaType, SubCategory subCategory, ApplicationStatus status, PaymentStatus paymentStatus, LocalDateTime submissionDate, PaymentMethod paymentMethod, String passportId, String applicantName, String photoUrl, String nationality, String address, String contactNumber, PaymentDTO payment) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.visaType = visaType;
        this.subCategory = subCategory;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.submissionDate = submissionDate;
        this.paymentMethod = paymentMethod;
        this.passportId = passportId;
        this.applicantName = applicantName;
        this.photoUrl = photoUrl;
        this.nationality = nationality;
        this.address = address;
        this.contactNumber = contactNumber;
        this.payment = payment;
    }

    // Getters and Setters
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

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }
}
