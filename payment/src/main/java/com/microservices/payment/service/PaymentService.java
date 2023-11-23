package com.microservices.payment.service;

import com.microservices.payment.mapper.PaymentMapper;
import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;
    public PaymentService(PaymentRepository paymentRepository,PaymentMapper paymentMapper){
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public PaymentDTO getPayment(String tranId){
        Optional<Payment> payment= paymentRepository.findByTranId(tranId);
        return paymentMapper.toPaymentDto(payment.get());
    }

    public void addPayment(AddPaymentDTO addPaymentDTO) {
        String tranId = UUID.randomUUID().toString();
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .amount(addPaymentDTO.getAmount())
                .patientId(addPaymentDTO.getPatientId())
                .tranId(tranId)
                .build();
        Payment payment = paymentMapper.toPayment(paymentDTO);
        paymentRepository.save(payment);
    }

    public List<PaymentDTO> getPaymentsByPatientId(Long patientId){
        List<Payment> payments = paymentRepository.findPaymentsByPatientId(patientId);
        return paymentMapper.toPaymentDto(payments);

    }
}
