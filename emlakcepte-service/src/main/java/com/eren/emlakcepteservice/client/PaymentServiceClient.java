package com.eren.emlakcepteservice.client;

import com.eren.emlakcepteservice.client.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "emlakcepte-payment-service", url = "localhost:8082/payments")
public interface PaymentServiceClient {

    @PostMapping
    Payment buyPublicationRights(@RequestBody Payment paymentRequest);

}
