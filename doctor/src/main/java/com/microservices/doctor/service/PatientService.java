package com.microservices.doctor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientService {

    public String getPatientName(String name){
        String fullUrl = "http://localhost:9000/patients/search/" + name;
        RestTemplate restTemplate = new RestTemplate();
        String patientName = restTemplate.getForObject(
                fullUrl, String.class);
        return patientName;

    }}
