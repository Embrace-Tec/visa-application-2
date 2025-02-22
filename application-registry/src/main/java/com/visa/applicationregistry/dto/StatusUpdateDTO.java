package com.visa.applicationregistry.dto;

import com.visa.applicationregistry.entity.ApplicationStatus;
import lombok.Data;

public class StatusUpdateDTO {
    private ApplicationStatus status;

    public StatusUpdateDTO(ApplicationStatus status) {
        this.status = status;
    }

    public StatusUpdateDTO() {
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
