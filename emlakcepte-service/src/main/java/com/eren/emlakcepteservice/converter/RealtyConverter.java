package com.eren.emlakcepteservice.converter;

import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import com.eren.emlakcepteservice.request.RealtyRequest;
import com.eren.emlakcepteservice.response.RealtyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
public class RealtyConverter {

    @Autowired
    private UserConverter userConverter;

    public RealtyResponse convert(Realty realty) {
        RealtyResponse response = new RealtyResponse();
        response.setId(realty.getId());
        response.setNo(realty.getNo());
        response.setTitle(realty.getTitle());
        response.setCreateDate(realty.getCreateDate());
        response.setStatus(realty.getStatus());
        response.setProvince(realty.getProvince());
        response.setDistrict(realty.getDistrict());
        response.setUserResponse(userConverter.convert(realty.getUser()));
        return response;
    }

    public Realty convert(RealtyRequest realtyRequest, User user){
        Realty realty = new Realty();
        realty.setNo(realtyRequest.getNo());
        realty.setTitle(realtyRequest.getTitle());
        realty.setProvince(realtyRequest.getProvince());
        realty.setDistrict(realtyRequest.getDistrict());
        realty.setStatus(RealtyStatus.IN_REVIEW);
        realty.setCreateDate(LocalDateTime.now());
        realty.setUser(user);
        return realty;
    }

    public List<RealtyResponse> convert(List<Realty> allRealty) {
        return allRealty.stream().map(this::convert).toList();
    }

}
