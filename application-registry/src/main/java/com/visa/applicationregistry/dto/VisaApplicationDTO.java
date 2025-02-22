package com.visa.applicationregistry.dto;


import com.visa.applicationregistry.entity.SubCategory;
import com.visa.applicationregistry.entity.VisaType;
import lombok.Data;

public class VisaApplicationDTO {
    private Long userId;
    private VisaType visaType;
    private SubCategory subCategory;

    public VisaApplicationDTO() {
    }

    public VisaApplicationDTO(Long userId, VisaType visaType, SubCategory subCategory) {
        this.userId = userId;
        this.visaType = visaType;
        this.subCategory = subCategory;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
