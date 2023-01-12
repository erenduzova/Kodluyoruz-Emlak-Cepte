package com.eren.emlakceptepaymentservice.service;

import com.eren.emlakceptepaymentservice.entity.Payment;
import com.eren.emlakceptepaymentservice.entity.enums.PaymentStatus;
import com.eren.emlakceptepaymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Use userId to get Users Bank information and pay
    public Payment pay(Payment paymentRequest) {
        Payment newPayment = new Payment(paymentRequest.getUserId(), paymentRequest.getPaymentStatus());
        // Payment can be unsuccessful ( Not Enough Money, User Has No Card Saved... )
        newPayment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        paymentRepository.save(newPayment);
        return newPayment;
    }

}
