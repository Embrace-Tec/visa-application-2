package com.visa.reviewandapprovalservice.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "approval_record")
public class ApprovalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id")
    private Long approvalId;

    @Column(name = "application_id", nullable = false)
    private Long visaApplicationId; // References Visa Application ID from Visa Application Registry Service

    @Column(name = "approved_by", nullable = false)
    private Long approvedBy; // References User ID from User Service

    @Enumerated(EnumType.STRING)
    @Column(name = "decision", nullable = false)
    private Decision decision;

    @Column(name = "decision_reason", length = 500)
    private String decisionReason;

    @Temporal(TemporalType.DATE)
    @Column(name = "review_date", nullable = false)
    private Date reviewDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "flag_status", nullable = false)
    private FlagStatus flagStatus;

    public ApprovalRecord(Long approvalId, Long visaApplicationId, Long approvedBy, Decision decision, String decisionReason, Date reviewDate, FlagStatus flagStatus) {
        this.approvalId = approvalId;
        this.visaApplicationId = visaApplicationId;
        this.approvedBy = approvedBy;
        this.decision = decision;
        this.decisionReason = decisionReason;
        this.reviewDate = reviewDate;
        this.flagStatus = flagStatus;
    }

    public ApprovalRecord() {
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Long getVisaApplicationId() {
        return visaApplicationId;
    }

    public void setVisaApplicationId(Long visaApplicationId) {
        this.visaApplicationId = visaApplicationId;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public String getDecisionReason() {
        return decisionReason;
    }

    public void setDecisionReason(String decisionReason) {
        this.decisionReason = decisionReason;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public FlagStatus getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(FlagStatus flagStatus) {
        this.flagStatus = flagStatus;
    }
}
