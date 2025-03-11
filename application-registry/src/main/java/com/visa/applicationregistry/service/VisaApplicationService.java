package com.visa.applicationregistry.service;

import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.entity.Payment;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.exception.ResourceNotFoundException;
import com.visa.applicationregistry.repository.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : L.H.J
 * @File: VisaApplicationService
 * @mailto : lharshana2002@gmail.com
 * @created : 2025-03-11, Tuesday
 **/
@Service
public class VisaApplicationService {

    @Autowired
    private VisaApplicationRepository visaApplicationRepository;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public VisaApplicationDTO createVisaApplication(VisaApplicationDTO visaApplicationDTO) {
        VisaApplication visaApplication = new VisaApplication();
        visaApplication.setUserId(visaApplicationDTO.getUserId());
        visaApplication.setVisaType(visaApplicationDTO.getVisaType());
        visaApplication.setSubCategory(visaApplicationDTO.getSubCategory());
        visaApplication.setStatus(visaApplicationDTO.getStatus());
        visaApplication.setPaymentStatus(visaApplicationDTO.getPaymentStatus());

        VisaApplication savedApplication = visaApplicationRepository.save(visaApplication);

        // Create and save payment
        Payment payment = new Payment();
        payment.setApplication(savedApplication);
        payment.setPaymentMethod(visaApplicationDTO.getPaymentMethod());
        payment.setPaymentStatus(visaApplicationDTO.getPaymentStatus());
        paymentService.savePayment(payment);

        return mapToDTO(savedApplication);
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
}
