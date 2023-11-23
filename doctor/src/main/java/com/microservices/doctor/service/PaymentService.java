package com.microservices.doctor.service;


import com.microservices.doctor.model.dto.payment.AddPaymentDTO;
import com.microservices.doctor.model.dto.payment.PaymentDTO;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentProxy paymentProxy;
    @Autowired
    PaymentService(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    public PaymentDTO getPayment(String id) { return paymentProxy.getPaymentByTranId(id);}

    public void addPayment(AddPaymentDTO addPaymentDTO){ paymentProxy.addPayment(addPaymentDTO);}
}
