package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.RealtyConverter;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.repository.RealtyRepository;
import com.eren.emlakcepteservice.request.RealtyRequest;
import com.eren.emlakcepteservice.response.RealtyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtyService {

    @Autowired
    private RealtyRepository realtyRepository;

    @Autowired
    private RealtyConverter realtyConverter;

    @Autowired
    private UserService userService;

    // Get All Realty
    public List<RealtyResponse> getAllRealtyResponse() {
        return realtyConverter.convert(realtyRepository.findAll());
    }

    // Create Realty
    public RealtyResponse create(RealtyRequest realtyRequest) {
        Realty newRealty = realtyConverter.convert(realtyRequest);
        User user = userService.getById(realtyRequest.getUserId());
        newRealty.setUser(user);
        realtyRepository.save(newRealty);
        return realtyConverter.convert(newRealty);
    }
}
