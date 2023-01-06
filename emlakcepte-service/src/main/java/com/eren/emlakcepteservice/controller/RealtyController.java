package com.eren.emlakcepteservice.controller;

import com.eren.emlakcepteservice.request.RealtyRequest;
import com.eren.emlakcepteservice.response.RealtyResponse;
import com.eren.emlakcepteservice.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/realty")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    // Get All Realty
    @GetMapping
    public ResponseEntity<List<RealtyResponse>> getAllRealtyResponse() {
        List<RealtyResponse> realtyResponses = realtyService.getAllRealtyResponse();;
        return new ResponseEntity<>(realtyResponses, HttpStatus.OK);
    }

    // Create Realty
    @PostMapping
    public ResponseEntity<RealtyResponse> create(@RequestBody RealtyRequest realtyRequest) {
        RealtyResponse savedRealty = realtyService.create(realtyRequest);
        return new ResponseEntity<>(savedRealty, HttpStatus.CREATED);
    }

    // Get User's Active Realty

    // Get User's All Realty

}
