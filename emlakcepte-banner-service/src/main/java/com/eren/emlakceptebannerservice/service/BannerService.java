package com.eren.emlakceptebannerservice.service;

import com.eren.emlakceptebannerservice.entity.Banner;
import com.eren.emlakceptebannerservice.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public Banner create(Banner banner) {
        Banner newBanner = new Banner(banner);
        return bannerRepository.save(newBanner);
    }

    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }
}
