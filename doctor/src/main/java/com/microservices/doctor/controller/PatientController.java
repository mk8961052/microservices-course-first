package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.patient.AddPatientDTO;
import com.microservices.doctor.model.dto.patient.PatientDto;
import com.microservices.doctor.model.dto.patient.UpdatePatientDTO;
import com.microservices.doctor.service.PatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/doctor")
public class PatientController {
    private PatientService patientService;
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @CircuitBreaker(name = "getPatientInstance" , fallbackMethod = "getDefaultPatient")
    @GetMapping("/get-patient")
    public PatientDto getPatient(@RequestParam Long id){return patientService.getPatient(id);}

    @PostMapping("/add-patient")
    public String addPatient(@RequestBody AddPatientDTO patientDTO){
        patientService.addPatient(patientDTO);
        return "PATIENT: " +patientDTO.getPatientName() + " ADDED SUCCESSFULLY !";
    }

    @PutMapping("/update-patient")
    public String updatePatient(@RequestBody UpdatePatientDTO patientDTO){
        patientService.updatePatient(patientDTO);
        return " PATIENT: " +patientDTO.getPatientName() + " UPDATED SUCCESSFULLY !";
    }

    @DeleteMapping("/delete-patient")
    public String deletePatient(@RequestParam Long id){
        patientService.deletePatient(id);
        return " PATIENT DELETED SUCCESSFULLY !";
    }

    public PatientDto getDefaultPatient(Exception e){
        return PatientDto.builder()
                .patientName("UNKNOWN-PATIENT")
                .id(0L)
                .patientAge("0")
                .build();
    }
}
