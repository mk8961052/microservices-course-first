package com.microservices.doctor.controller;

import com.microservices.doctor.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class PatientController {
    private PatientService patientService;
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/get-patient")
    public String getPatient(){
        return patientService.getPatientName("Mohamed ");

    }
}
