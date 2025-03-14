package com.visa.applicationregistry.service;

import com.visa.applicationregistry.dto.PaymentDTO;
import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.entity.ApplicationStatus;
import com.visa.applicationregistry.entity.Payment;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.entity.VisaApplicationDetails;
import com.visa.applicationregistry.exception.ResourceNotFoundException;
import com.visa.applicationregistry.repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisaApplicationService {

    @Autowired
    private VisaApplicationRepository visaApplicationRepository;

    @Autowired
    private PaymentService paymentService;

    public VisaApplicationDTO createVisaApplication(VisaApplicationDTO visaApplicationDTO) {
        VisaApplication visaApplication = new VisaApplication();
        visaApplication.setUserId(visaApplicationDTO.getUserId());
        visaApplication.setVisaType(visaApplicationDTO.getVisaType());
        visaApplication.setSubCategory(visaApplicationDTO.getSubCategory());
        visaApplication.setStatus(visaApplicationDTO.getStatus());
        visaApplication.setSubmissionDate(LocalDateTime.now());
        visaApplication.setPaymentStatus(visaApplicationDTO.getPaymentStatus());

        // Save VisaApplicationDetails
        VisaApplicationDetails visaApplicationDetails = new VisaApplicationDetails();
        visaApplicationDetails.setPassportId(visaApplicationDTO.getPassportId());
        visaApplicationDetails.setApplicantName(visaApplicationDTO.getApplicantName());
        visaApplicationDetails.setPhotoUrl(visaApplicationDTO.getPhotoUrl());
        visaApplicationDetails.setNationality(visaApplicationDTO.getNationality());
        visaApplicationDetails.setAddress(visaApplicationDTO.getAddress());
        visaApplicationDetails.setContactNumber(visaApplicationDTO.getContactNumber());
        visaApplicationDetails.setVisaApplication(visaApplication);

        visaApplication.setVisaApplicationDetails(visaApplicationDetails);

        // Save Payment Details
        PaymentDTO paymentDTO = visaApplicationDTO.getPayment();
        if (paymentDTO != null) {
            Payment payment = new Payment();
            payment.setPaymentMethod(paymentDTO.getPaymentMethod());
            payment.setPaymentStatus(paymentDTO.getPaymentStatus());
            payment.setTransactionDate(LocalDateTime.now());
            payment.setApplication(visaApplication);

            visaApplication.setPayment(payment);
        }

        VisaApplication savedApplication = visaApplicationRepository.save(visaApplication);

        return convertToDTO(savedApplication);
    }

    public List<VisaApplicationDTO> getPendingVisaApplications() {
        // Fetch all applications with status = PENDING
        List<VisaApplication> pendingApplications = visaApplicationRepository.findByStatus(ApplicationStatus.PENDING);

        // Convert entities to DTOs
        return pendingApplications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private VisaApplicationDTO convertToDTO(VisaApplication visaApplication) {
        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setApplicationId(visaApplication.getApplicationId());
        dto.setUserId(visaApplication.getUserId());
        dto.setVisaType(visaApplication.getVisaType());
        dto.setSubCategory(visaApplication.getSubCategory());
        dto.setStatus(visaApplication.getStatus());
        dto.setSubmissionDate(visaApplication.getSubmissionDate());
        dto.setPaymentStatus(visaApplication.getPaymentStatus());

        VisaApplicationDetails details = visaApplication.getVisaApplicationDetails();
        if (details != null) {
            dto.setPassportId(details.getPassportId());
            dto.setApplicantName(details.getApplicantName());
            dto.setPhotoUrl(details.getPhotoUrl());
            dto.setNationality(details.getNationality());
            dto.setAddress(details.getAddress());
            dto.setContactNumber(details.getContactNumber());
        }

        Payment payment = visaApplication.getPayment();
        if (payment != null) {
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setPaymentId(payment.getPaymentId());
            paymentDTO.setPaymentMethod(payment.getPaymentMethod());
            paymentDTO.setPaymentStatus(payment.getPaymentStatus());
            paymentDTO.setTransactionDate(payment.getTransactionDate());
            dto.setPayment(paymentDTO);
        }

        return dto;
    }

    public VisaApplicationDTO getVisaApplicationById(Long id) {
        VisaApplication visaApplication = visaApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication not found with id: " + id));
        return mapToDTO(visaApplication);
    }

    public List<VisaApplicationDTO> getAllVisaApplications() {
        return visaApplicationRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public VisaApplicationDTO updateVisaApplication(Long id, VisaApplicationDTO visaApplicationDTO) {
        VisaApplication visaApplication = visaApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication not found with id: " + id));

        visaApplication.setUserId(visaApplicationDTO.getUserId());
        visaApplication.setVisaType(visaApplicationDTO.getVisaType());
        visaApplication.setSubCategory(visaApplicationDTO.getSubCategory());
        visaApplication.setStatus(visaApplicationDTO.getStatus());
        visaApplication.setPaymentStatus(visaApplicationDTO.getPaymentStatus());

        VisaApplication updatedApplication = visaApplicationRepository.save(visaApplication);
        return mapToDTO(updatedApplication);
    }

    @Transactional
    public void deleteVisaApplication(Long id) {
        VisaApplication visaApplication = visaApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication not found with id: " + id));
        visaApplicationRepository.delete(visaApplication);
    }

    private VisaApplicationDTO mapToDTO(VisaApplication visaApplication) {
        VisaApplicationDTO dto = new VisaApplicationDTO();
        dto.setApplicationId(visaApplication.getApplicationId());
        dto.setUserId(visaApplication.getUserId());
        dto.setVisaType(visaApplication.getVisaType());
        dto.setSubCategory(visaApplication.getSubCategory());
        dto.setStatus(visaApplication.getStatus());
        dto.setPaymentStatus(visaApplication.getPaymentStatus());
        dto.setSubmissionDate(visaApplication.getSubmissionDate());
        return dto;
    }

    public VisaApplicationDTO updateApplicationStatus(Long id, ApplicationStatus status) {
        VisaApplication visaApplication = visaApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisaApplication not found with id: " + id));
        visaApplication.setStatus(status);

        VisaApplication updatedApplication = visaApplicationRepository.save(visaApplication);

        VisaApplicationDTO visaApplicationDTO = new VisaApplicationDTO();
        visaApplicationDTO.setApplicationId(updatedApplication.getApplicationId());
        visaApplicationDTO.setUserId(updatedApplication.getUserId());
        visaApplicationDTO.setVisaType(updatedApplication.getVisaType());
        visaApplicationDTO.setSubCategory(updatedApplication.getSubCategory());
        visaApplicationDTO.setStatus(updatedApplication.getStatus());
        visaApplicationDTO.setSubmissionDate(updatedApplication.getSubmissionDate());
        visaApplicationDTO.setPaymentStatus(updatedApplication.getPaymentStatus());

        return visaApplicationDTO;
    }
}
