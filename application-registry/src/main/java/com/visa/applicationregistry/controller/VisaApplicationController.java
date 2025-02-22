package com.visa.applicationregistry.controller;


import com.visa.applicationregistry.dto.StatusUpdateDTO;
import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.entity.VisaApplication;
import com.visa.applicationregistry.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visa-applications")
public class VisaApplicationController {

    private final VisaApplicationService service;


    public VisaApplicationController(VisaApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public VisaApplication createApplication(@RequestBody VisaApplicationDTO dto) {
        return service.createApplication(dto);
    }

    @GetMapping("/{id}")
    public VisaApplication getApplication(@PathVariable Long id) {
        return service.getApplication(id);
    }

    @PutMapping("/{id}/status")
    public VisaApplication updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO dto) {
        return service.updateStatus(id, dto.getStatus());
    }
}