package com.eren.emlakcepteservice.controller;

import com.eren.emlakcepteservice.request.RealtyRequest;
import com.eren.emlakcepteservice.request.RealtyUpdateRequest;
import com.eren.emlakcepteservice.response.ProvinceResponse;
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

    // Update Realty
    @PutMapping(value = "/{realtyId}")
    public ResponseEntity<RealtyResponse> update(@PathVariable Integer realtyId, @RequestBody RealtyUpdateRequest realtyUpdateRequest) {
        RealtyResponse updatedRealty = realtyService.update(realtyId, realtyUpdateRequest);
        return new ResponseEntity<>(updatedRealty, HttpStatus.OK);
    }

    // Get User's Active Realty
    @GetMapping(value = "/{userId}/active")
    public ResponseEntity<List<RealtyResponse>> getUserActiveRealty(@PathVariable Integer userId) {
        List<RealtyResponse> activeRealty = realtyService.getUserActive(userId);
        return new ResponseEntity<>(activeRealty,HttpStatus.FOUND);
    }

    // Get User's Passive Realty
    @GetMapping(value = "/{userId}/passive")
    public ResponseEntity<List<RealtyResponse>> getUserPassiveRealty(@PathVariable Integer userId) {
        List<RealtyResponse> passiveRealty = realtyService.getUserPassive(userId);
        return new ResponseEntity<>(passiveRealty,HttpStatus.FOUND);
    }

    // Get Province Realty Display
    @GetMapping(value = "/display/{province}")
    public ResponseEntity<List<RealtyResponse>> getProvinceDisplay(@PathVariable String province) {
        List<RealtyResponse> provinceDisplay = realtyService.getProvinceDisplay(province);
        return new ResponseEntity<>(provinceDisplay, HttpStatus.OK);
    }

    // Get Province Response ( Counts of the Realty Types)
    @GetMapping(value = "/{province}")
    public ResponseEntity<ProvinceResponse> getProvinceResponse(@PathVariable String province) {
        ProvinceResponse provinceResponse = realtyService.getProvinceResponse(province);
        return new ResponseEntity<>(provinceResponse, HttpStatus.OK);
    }


}
