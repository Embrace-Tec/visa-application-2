package com.visa.reviewandapprovalservice.dto;
import jakarta.validation.constraints.NotNull;

public class ApprovalRequestDTO {
    @NotNull(message = "Application ID cannot be null")
    private Long applicationId;

    @NotNull(message = "Approved By cannot be null")
    private Long approvedBy;

    @NotNull(message = "Decision cannot be null")
    private String decision;

    @NotNull(message = "Decision reason cannot be null")
    private String decisionReason;

    // Getters and Setters
    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getDecisionReason() {
        return decisionReason;
    }

    public void setDecisionReason(String decisionReason) {
        this.decisionReason = decisionReason;
    }
}
