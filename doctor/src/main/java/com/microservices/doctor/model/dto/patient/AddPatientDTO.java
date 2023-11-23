package com.microservices.doctor.model.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPatientDTO {
    private String patientName;
    private String patientAge;
}
