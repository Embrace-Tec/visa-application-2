package com.visa.applicationregistry.repository;

import com.visa.applicationregistry.entity.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, Long> {
}