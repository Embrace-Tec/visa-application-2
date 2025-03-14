package com.visa.applicationregistry.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "visa_application_details")
public class VisaApplicationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailsId;

    private String passportId;
    private String applicantName;
    private String photoUrl;
    private String nationality;
    private String address;
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "application_id", nullable = false)
    private VisaApplication visaApplication;

    // Constructors, Getters, and Setters
    public VisaApplicationDetails() {
    }

    public VisaApplicationDetails(String passportId, String applicantName, String photoUrl, String nationality, String address, String contactNumber, VisaApplication visaApplication) {
        this.passportId = passportId;
        this.applicantName = applicantName;
        this.photoUrl = photoUrl;
        this.nationality = nationality;
        this.address = address;
        this.contactNumber = contactNumber;
        this.visaApplication = visaApplication;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
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

    public VisaApplication getVisaApplication() {
        return visaApplication;
    }

    public void setVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }
}