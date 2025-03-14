package com.visa.reviewandapprovalservice.repository;

import com.visa.reviewandapprovalservice.entity.ApprovalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApprovalRecordRepository extends JpaRepository<ApprovalRecord, Long> {
    List<ApprovalRecord> findByReviewDateBetween(Date startDate, Date endDate);
}