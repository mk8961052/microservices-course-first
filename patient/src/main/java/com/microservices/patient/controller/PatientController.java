package com.microservices.patient.controller;

import com.microservices.patient.model.dto.patientdto.AddPatientDTO;
import com.microservices.patient.model.dto.patientdto.PatientDto;
import com.microservices.patient.model.dto.patientdto.UpdatePatientDTO;
import com.microservices.patient.model.dto.paymentdto.PaymentDTO;
import com.microservices.patient.service.PatientPaymentService;
import com.microservices.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    private PatientPaymentService patientPaymentService;

    PatientController(PatientService patientService,PatientPaymentService patientPaymentService) {
        this.patientService = patientService;
        this.patientPaymentService = patientPaymentService;
    }

    @PostMapping("/add-patient")
    public void savePatient(@RequestBody AddPatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
    }

    @PutMapping("/update-patient")
    public PatientDto updatePatient(@RequestBody UpdatePatientDTO patientDTO) {
       return patientService.UpdatePatient(patientDTO);
    }

    @DeleteMapping("/delete-patient")
    public void deletePatient(@RequestParam Long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/get-patient")
    public PatientDto getPatient(@RequestParam Long id){return patientService.getPatient(id);}

    @GetMapping("/get-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long patientId){
        return patientPaymentService.getPaymentsByPatientId(patientId);
    }
}