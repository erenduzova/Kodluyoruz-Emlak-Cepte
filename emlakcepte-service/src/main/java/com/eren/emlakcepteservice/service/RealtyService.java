package com.eren.emlakcepteservice.service;

import com.eren.emlakcepteservice.converter.RealtyConverter;
import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
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

    // Create Realty
    public RealtyResponse create(RealtyRequest realtyRequest) {
        User user = userService.getById(realtyRequest.getUserId());
        Realty newRealty = realtyConverter.convert(realtyRequest, user);
        realtyRepository.save(newRealty);
        return realtyConverter.convert(newRealty);
    }

    // Get All Realty
    public List<RealtyResponse> getAllRealtyResponse() {
        return realtyConverter.convert(realtyRepository.findAll());
    }

    // Get User's All Realty
    public List<RealtyResponse> getUserAll(Integer userId) {
        User user = userService.getById(userId);
        List<Realty> allRealty = realtyRepository.findAllByUser(user);
        return realtyConverter.convert(allRealty);
    }

    // Get User's Active Realty
    public List<RealtyResponse> getUserActive(Integer userId) {
        User user = userService.getById(userId);
        List<Realty> activeRealty = realtyRepository.findRealtyByStatusAndUser(RealtyStatus.ACTIVE, user);
        return realtyConverter.convert(activeRealty);
    }

    // Get User's Passive Realty
    public List<RealtyResponse> getUserPassive(Integer userId) {
        User user = userService.getById(userId);
        List<Realty> passiveRealty = realtyRepository.findRealtyByStatusAndUser(RealtyStatus.PASSIVE, user);
        return realtyConverter.convert(passiveRealty);
    }


    public List<Realty> getAllByProvince(String searchedProvince) {
        return realtyRepository.findAllByProvince(searchedProvince);
    }

    public List<Realty> getAllByDistrict(String searchedDistrict) {
        return realtyRepository.findAllByDistrict(searchedDistrict);
    }
}
