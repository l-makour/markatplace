package com.checkconsulting.markatplace.controller;

import com.checkconsulting.markatplace.modelDto.CustomerDto;
import com.checkconsulting.markatplace.modelDto.ProductDto;
import com.checkconsulting.markatplace.service.CustomerService;
import org.aspectj.bridge.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id){
       CustomerDto customerDto=customerService.getById(id);
        if (customerDto==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
    }

}
