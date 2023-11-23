package com.microservices.payment.controller;

import com.microservices.payment.model.dto.AddPaymentDTO;
import com.microservices.payment.model.dto.PaymentDTO;
import com.microservices.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam String tranId){
       return paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public String addPayment(@RequestBody AddPaymentDTO addPaymentDTO){
        paymentService.addPayment(addPaymentDTO);
        return " PAYMENT ADDED ! ";
    }

    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestHeader Long patientId){
        return paymentService.getPaymentsByPatientId(patientId);
    }


}
