package com.microservices.patient.mapper;

import com.microservices.patient.model.dto.patientdto.AddPatientDTO;
import com.microservices.patient.model.dto.patientdto.PatientDto;
import com.microservices.patient.model.dto.patientdto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity (PatientDto patientDto);
    PatientDto toDto(Patient patient);
    Patient updateToEntity(UpdatePatientDTO updatePatientDTO);
    Patient addToEntity(AddPatientDTO addPatientDTO);
}
