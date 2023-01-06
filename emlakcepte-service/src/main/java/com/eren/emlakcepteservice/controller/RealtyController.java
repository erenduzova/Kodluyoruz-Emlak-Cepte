package com.eren.emlakcepteservice.controller;

import com.eren.emlakcepteservice.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/realty")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;



}
