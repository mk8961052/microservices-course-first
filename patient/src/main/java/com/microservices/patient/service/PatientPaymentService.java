package com.microservices.patient.service;

import com.microservices.patient.model.dto.paymentdto.PaymentDTO;
import com.microservices.patient.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientPaymentService {
    @Autowired
    private PaymentProxy paymentProxy;
    public PatientPaymentService(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }
    public List<PaymentDTO> getPaymentsByPatientId(Long patientId){
        return paymentProxy.getPatientPayments(patientId);
    }
}


