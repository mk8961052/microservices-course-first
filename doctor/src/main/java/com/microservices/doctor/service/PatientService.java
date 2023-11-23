package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.patient.AddPatientDTO;
import com.microservices.doctor.model.dto.patient.PatientDto;
import com.microservices.doctor.model.dto.patient.UpdatePatientDTO;
import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private PatientProxy patientProxy;

    @Autowired
    PatientService(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }

    public PatientDto getPatient(long id) {
        return patientProxy.getPatient(id);
    }

    public void addPatient(AddPatientDTO patientDTO){ patientProxy.savePatient(patientDTO);}

    public void updatePatient(UpdatePatientDTO patientDTO){ patientProxy.updatePatient(patientDTO);}

    public void deletePatient(long id) { patientProxy.deletePatient(id);}

}