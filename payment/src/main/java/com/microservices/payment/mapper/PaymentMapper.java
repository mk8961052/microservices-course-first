package com.microservices.payment.mapper;

import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toPayment(PaymentDTO paymentDto);
    PaymentDTO toPaymentDto(Payment payment);
    List<Payment> toPayment(List<PaymentDTO> paymentDtos);
    List<PaymentDTO> toPaymentDto(List<Payment> payments);
}
