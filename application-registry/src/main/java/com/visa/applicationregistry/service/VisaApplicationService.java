package com.visa.applicationregistry.service;


import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.entity.ApplicationStatus;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.repository.VisaApplicationRepository;

import java.util.List;
import java.util.Optional;

public interface VisaApplicationService {
    VisaApplication createApplication(VisaApplicationDTO dto);
    VisaApplication getApplication(Long id);
    VisaApplication updateStatus(Long id, ApplicationStatus status);
}