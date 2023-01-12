package com.eren.emlakceptepaymentservice.controller;

import com.eren.emlakceptepaymentservice.entity.Payment;
import com.eren.emlakceptepaymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping
    public Payment buyPublicationRights(@RequestBody Payment paymentRequest){
        return paymentService.pay(paymentRequest);
    }

}
