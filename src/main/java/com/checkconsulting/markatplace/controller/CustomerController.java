package com.checkconsulting.markatplace.controller;

import com.checkconsulting.markatplace.modelDto.CustomerDto;
import com.checkconsulting.markatplace.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllProduct(){
        return ResponseEntity.ok(customerService.getAll());
    }

}
