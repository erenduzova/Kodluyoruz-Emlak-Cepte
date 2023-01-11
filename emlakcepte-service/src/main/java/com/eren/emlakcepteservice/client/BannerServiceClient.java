package com.eren.emlakcepteservice.client;

import com.eren.emlakcepteservice.client.model.Banner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "emlakcepte-banner-service", url = "localhost:8081/banners")
public interface BannerServiceClient {

    @PostMapping
    Banner create(@RequestBody Banner banner);

    @GetMapping
    List<Banner> getAll();

}
