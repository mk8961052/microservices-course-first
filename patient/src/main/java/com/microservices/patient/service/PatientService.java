package com.microservices.patient.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {
    public List<String> patients = Arrays.asList("Mohamed","Said","Omar");

    public String getPatientName(String patientName){
        return patients.stream().filter(name -> name.equals(patientName))
                .findAny().orElse("No Patient With This Name");

    }
}
