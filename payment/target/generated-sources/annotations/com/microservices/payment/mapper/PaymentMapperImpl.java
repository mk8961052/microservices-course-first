package com.microservices.payment.mapper;

import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO.PaymentDTOBuilder;
import com.microservices.payment.model.entity.Payment;
import com.microservices.payment.model.entity.Payment.PaymentBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-21T20:04:07+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toPayment(PaymentDTO paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        PaymentBuilder payment = Payment.builder();

        payment.id( paymentDto.getId() );
        payment.tranId( paymentDto.getTranId() );
        payment.amount( paymentDto.getAmount() );
        payment.patientId( paymentDto.getPatientId() );

        return payment.build();
    }

    @Override
    public PaymentDTO toPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDTOBuilder paymentDTO = PaymentDTO.builder();

        paymentDTO.id( payment.getId() );
        paymentDTO.tranId( payment.getTranId() );
        paymentDTO.amount( payment.getAmount() );
        paymentDTO.patientId( payment.getPatientId() );

        return paymentDTO.build();
    }

    @Override
    public List<Payment> toPayment(List<PaymentDTO> paymentDtos) {
        if ( paymentDtos == null ) {
            return null;
        }

        List<Payment> list = new ArrayList<Payment>( paymentDtos.size() );
        for ( PaymentDTO paymentDTO : paymentDtos ) {
            list.add( toPayment( paymentDTO ) );
        }

        return list;
    }

    @Override
    public List<PaymentDTO> toPaymentDto(List<Payment> payments) {
        if ( payments == null ) {
            return null;
        }

        List<PaymentDTO> list = new ArrayList<PaymentDTO>( payments.size() );
        for ( Payment payment : payments ) {
            list.add( toPaymentDto( payment ) );
        }

        return list;
    }
}
