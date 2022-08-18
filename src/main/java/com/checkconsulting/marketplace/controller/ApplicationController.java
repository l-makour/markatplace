package com.checkconsulting.marketplace.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {


    @Value("${env}")
    String env;


    @GetMapping("api/v1/env")
    public String getEnv() {
        return env;
    }


}
