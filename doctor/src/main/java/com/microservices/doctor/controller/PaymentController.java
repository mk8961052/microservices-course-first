package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.payment.AddPaymentDTO;
import com.microservices.doctor.model.dto.payment.PaymentDTO;
import com.microservices.doctor.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/doctor")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @GetMapping("/get-payment")
    public PaymentDTO getPayment(@RequestParam String tranId){
        return paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public String addPatient(@RequestBody AddPaymentDTO addPaymentDTO){
        paymentService.addPayment(addPaymentDTO);
        return " PAYMENT ADDED SUCCESSFULLY !";
    }
}
