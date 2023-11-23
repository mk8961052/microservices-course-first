package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.patient.AddPatientDTO;
import com.microservices.doctor.model.dto.patient.PatientDto;
import com.microservices.doctor.model.dto.patient.UpdatePatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PATIENT-SERVICE", path = "/patient")
public interface PatientProxy {
    @GetMapping("/get-patient")
    public PatientDto getPatient(@RequestParam Long id);

    @PostMapping("/add-patient")
    public void savePatient(@RequestBody AddPatientDTO patientDTO);

    @PutMapping("/update-patient")
    public PatientDto updatePatient(@RequestBody UpdatePatientDTO patientDTO);

    @DeleteMapping("/delete-patient")
    public void deletePatient(@RequestParam Long id);
}
