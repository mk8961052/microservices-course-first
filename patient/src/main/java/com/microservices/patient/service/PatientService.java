package com.microservices.patient.service;

import com.microservices.patient.mapper.PatientMapper;
import com.microservices.patient.model.dto.patientdto.AddPatientDTO;
import com.microservices.patient.model.dto.patientdto.PatientDto;
import com.microservices.patient.model.dto.patientdto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private PatientRepository patientRepository ;
    private PatientMapper patientMapper;
    @Autowired
    PatientService(PatientRepository patientRepository, PatientMapper patientMapper){
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }
    public void savePatient(AddPatientDTO patientDTO){
        Patient patient = patientMapper.addToEntity(patientDTO);
       Patient newPatient = patientRepository.save(patient);
       //return patientMapper.toDto(newPatient);
    }
    public PatientDto UpdatePatient(UpdatePatientDTO patientDTO){
        Patient patient = patientMapper.updateToEntity(patientDTO);
        Patient newPatient = patientRepository.save(patient);
        return patientMapper.toDto(newPatient);
    }

    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }

    public PatientDto getPatient(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDto patientDto = patientMapper.toDto(patient.get());
        return patientDto;

    }

}
