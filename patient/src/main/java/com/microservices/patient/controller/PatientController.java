package com.microservices.patient.controller;

import com.microservices.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/search/{name}")
    public String getPatient(@PathVariable("name") String name){
        return patientService.getPatientName(name);

    }
}
