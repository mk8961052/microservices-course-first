package com.microservices.patient.model.dto.paymentdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentDTO {

    private Double amount;
    private Long patientId;
}
