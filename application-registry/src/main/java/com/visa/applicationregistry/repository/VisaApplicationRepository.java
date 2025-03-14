package com.visa.applicationregistry.repository;

import com.visa.applicationregistry.entity.ApplicationStatus;
import com.visa.applicationregistry.entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
    List<VisaApplication> findByStatus(ApplicationStatus status);

}