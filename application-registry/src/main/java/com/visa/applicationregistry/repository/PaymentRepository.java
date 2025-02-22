package com.visa.applicationregistry.repository;

import com.visa.applicationregistry.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
