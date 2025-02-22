package com.visa.applicationregistry.service.impl;


import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.entity.ApplicationStatus;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.repository.VisaApplicationRepository;
import com.visa.applicationregistry.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VisaApplicationServiceImpl implements VisaApplicationService {

    private final VisaApplicationRepository repository;

    public VisaApplicationServiceImpl(VisaApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisaApplication createApplication(VisaApplicationDTO dto) {
        VisaApplication application = new VisaApplication();
        application.setUserId(dto.getUserId());
        application.setVisaType(dto.getVisaType());
        application.setSubCategory(dto.getSubCategory());
        return repository.save(application);
    }

    @Override
    public VisaApplication getApplication(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public VisaApplication updateStatus(Long id, ApplicationStatus status) {
        VisaApplication application = repository.findById(id).orElseThrow();
        application.setStatus(status);
        return repository.save(application);
    }
}