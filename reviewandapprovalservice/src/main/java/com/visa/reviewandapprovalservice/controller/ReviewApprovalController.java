package com.visa.reviewandapprovalservice.controller;

import com.visa.reviewandapprovalservice.dto.ApprovalRequestDTO;
import com.visa.reviewandapprovalservice.dto.VisaApplicationDTO;
import com.visa.reviewandapprovalservice.entity.ApprovalRecord;
import com.visa.reviewandapprovalservice.service.ReviewApprovalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/review-approval")
public class ReviewApprovalController {


    @Autowired
    private ReviewApprovalService reviewApprovalService;
    @GetMapping("/pending")
    public ResponseEntity<List<VisaApplicationDTO>> getPendingApplications() {
        List<VisaApplicationDTO> pendingApplications = reviewApprovalService.getPendingApplications();
        return ResponseEntity.ok(pendingApplications);
    }

    @PostMapping("/review")
    public ResponseEntity<ApprovalRecord> reviewAndApproveApplication(@Valid @RequestBody ApprovalRequestDTO approvalRequest) {
        System.out.println("Reviewing application with ID: " + approvalRequest.getApplicationId());
        ApprovalRecord record = reviewApprovalService.reviewAndApproveApplication(
                approvalRequest.getApplicationId(),
                approvalRequest.getApprovedBy(),
                approvalRequest.getDecision(),
                approvalRequest.getDecisionReason()
        );
        return ResponseEntity.ok(record);
    }

    @GetMapping("/history")
    public ResponseEntity<List<ApprovalRecord>> getVisaApplicationHistory(
            @RequestParam Date startDate,
            @RequestParam Date endDate,
            @RequestParam String visaType) {
        List<ApprovalRecord> history = reviewApprovalService.getVisaApplicationHistory(startDate, endDate, visaType);
        return ResponseEntity.ok(history);
    }
}