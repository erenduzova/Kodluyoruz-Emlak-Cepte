package com.eren.emlakcepteservice.client.model;

import com.eren.emlakcepteservice.client.model.enums.PaymentStatus;

public class Payment {

    private Integer userId;
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(Integer userId, PaymentStatus paymentStatus) {
        this.userId = userId;
        this.paymentStatus = paymentStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
