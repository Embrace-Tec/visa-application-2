package com.visa.applicationregistry.controller;

import com.visa.applicationregistry.dto.VisaApplicationDTO;
import com.visa.applicationregistry.service.VisaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/visa-applications")
public class VisaApplicationController {

    @Autowired
    private VisaApplicationService visaApplicationService;

    @Autowired
    private RestTemplate restTemplate;

    private final String userServiceUrl = "http://localhost:8084";
    @PostMapping
    public ResponseEntity<VisaApplicationDTO> createVisaApplication(@RequestBody VisaApplicationDTO visaApplicationDTO,
                                                                    @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        if (!isValidUserToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        VisaApplicationDTO createdApplication = visaApplicationService.createVisaApplication(visaApplicationDTO);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }

    private boolean isValidUserToken(String token) {
        String url = userServiceUrl + "/auth/validate";

        System.out.println("Validating token: " + token);
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.GET,
                new org.springframework.http.HttpEntity<>(null,
                        new HttpHeaders() {{
                            add(HttpHeaders.AUTHORIZATION, token);
                        }}),
                Void.class);

        return response.getStatusCode() == HttpStatus.OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisaApplicationDTO> getVisaApplicationById(@PathVariable Long id) {
        VisaApplicationDTO visaApplicationDTO = visaApplicationService.getVisaApplicationById(id);
        return ResponseEntity.ok(visaApplicationDTO);
    }

    @GetMapping
    public ResponseEntity<List<VisaApplicationDTO>> getAllVisaApplications() {
        List<VisaApplicationDTO> visaApplications = visaApplicationService.getAllVisaApplications();
        return ResponseEntity.ok(visaApplications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisaApplicationDTO> updateVisaApplication(@PathVariable Long id, @RequestBody VisaApplicationDTO visaApplicationDTO) {
        VisaApplicationDTO updatedApplication = visaApplicationService.updateVisaApplication(id, visaApplicationDTO);
        return ResponseEntity.ok(updatedApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisaApplication(@PathVariable Long id) {
        visaApplicationService.deleteVisaApplication(id);
        return ResponseEntity.noContent().build();
    }
}
