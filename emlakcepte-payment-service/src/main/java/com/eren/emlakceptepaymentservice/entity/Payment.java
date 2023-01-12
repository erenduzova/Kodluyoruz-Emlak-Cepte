package com.eren.emlakceptepaymentservice.entity;

import com.eren.emlakceptepaymentservice.entity.enums.PaymentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    public Payment() {
    }

    public Payment(Integer userId, PaymentStatus paymentStatus) {
        this.userId = userId;
        this.paymentStatus = paymentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
