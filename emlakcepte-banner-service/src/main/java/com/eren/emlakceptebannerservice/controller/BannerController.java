package com.eren.emlakceptebannerservice.controller;

import com.eren.emlakceptebannerservice.entity.Banner;
import com.eren.emlakceptebannerservice.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/banners")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping
    Banner create(@RequestBody Banner banner) {
        return bannerService.create(banner);
    }

    @GetMapping
    List<Banner> getAll() {
        return bannerService.getAll();
    }

}
