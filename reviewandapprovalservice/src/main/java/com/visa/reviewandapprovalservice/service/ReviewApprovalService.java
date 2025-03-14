package com.visa.reviewandapprovalservice.service;

import com.visa.reviewandapprovalservice.dto.VisaApplicationDTO;
import com.visa.reviewandapprovalservice.entity.ApprovalRecord;
import com.visa.reviewandapprovalservice.entity.Decision;
import com.visa.reviewandapprovalservice.entity.FlagStatus;
import com.visa.reviewandapprovalservice.repository.ApprovalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewApprovalService {

    @Autowired
    private ApprovalRecordRepository approvalRecordRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String visaApplicationServiceUrl = "http://localhost:8083";
    private final String userServiceUrl = "http://localhost:8084";

    public List<VisaApplicationDTO> getPendingApplications() {
        String url = visaApplicationServiceUrl + "/api/visa-applications/pending";
        return restTemplate.getForObject(url, List.class);
    }

    public ApprovalRecord reviewAndApproveApplication(Long applicationId, Long approvedBy, String decision, String decisionReason) {
        String url = visaApplicationServiceUrl + "/api/visa-applications/" + applicationId;
        VisaApplicationDTO visaApplication = restTemplate.getForObject(url, VisaApplicationDTO.class);

        FlagStatus flagStatus = FlagStatus.GREEN;

        if (Decision.REJECTED.name().equalsIgnoreCase(decision)) {
            String rejectUrl = visaApplicationServiceUrl + "/api/visa-applications/" + applicationId + "/reject";
            restTemplate.put(rejectUrl, null);

            ApprovalRecord rejectionRecord = new ApprovalRecord();
            rejectionRecord.setVisaApplicationId(applicationId);
            rejectionRecord.setApprovedBy(approvedBy);
            rejectionRecord.setDecision(Decision.REJECTED);
            rejectionRecord.setDecisionReason(decisionReason);
            rejectionRecord.setReviewDate(new Date());
            rejectionRecord.setFlagStatus(flagStatus);
            return approvalRecordRepository.save(rejectionRecord);
        } else if (Decision.APPROVED.name().equalsIgnoreCase(decision)) {
            String approveUrl = visaApplicationServiceUrl + "/api/visa-applications/" + applicationId + "/approve";
            restTemplate.put(approveUrl, null);

            ApprovalRecord approvalRecord = new ApprovalRecord();
            approvalRecord.setVisaApplicationId(applicationId);
            approvalRecord.setApprovedBy(approvedBy);
            approvalRecord.setDecision(Decision.APPROVED);
            approvalRecord.setDecisionReason(decisionReason);
            approvalRecord.setReviewDate(new Date());
            approvalRecord.setFlagStatus(flagStatus);
            return approvalRecordRepository.save(approvalRecord);
        } else if (Decision.PENDING.name().equalsIgnoreCase(decision)) {
            String resetUrl = visaApplicationServiceUrl + "/api/visa-applications/" + applicationId + "/reset";
            restTemplate.put(resetUrl, null);

            ApprovalRecord resetRecord = new ApprovalRecord();
            resetRecord.setVisaApplicationId(applicationId);
            resetRecord.setApprovedBy(approvedBy);
            resetRecord.setDecision(Decision.PENDING);
            resetRecord.setDecisionReason(decisionReason);
            resetRecord.setReviewDate(new Date());
            resetRecord.setFlagStatus(flagStatus);
            return approvalRecordRepository.save(resetRecord);
        } else {
            throw new IllegalArgumentException("Invalid decision: " + decision);
        }
    }

    public List<ApprovalRecord> getVisaApplicationHistory(Date startDate, Date endDate, String visaType) {
        List<ApprovalRecord> approvalRecords = approvalRecordRepository.findByReviewDateBetween(startDate, endDate);
        return approvalRecords.stream()
                .filter(record -> {
                    String url = visaApplicationServiceUrl + "/api/visa-applications/" + record.getVisaApplicationId();
                    VisaApplicationDTO visaApplication = restTemplate.getForObject(url, VisaApplicationDTO.class);
                    return visaType.equals(visaApplication.getVisaType().toString());
                })
                .collect(Collectors.toList());
    }
}
