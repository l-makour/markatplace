package com.checkconsulting.marketplace.controller;

import com.checkconsulting.marketplace.enums.ResponseStatus;
import com.checkconsulting.marketplace.exceptions.NotFoundException;
import com.checkconsulting.marketplace.utils.ResponseGeneric;
import com.checkconsulting.marketplace.modelDto.CustomerDto;
import com.checkconsulting.marketplace.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<ResponseGeneric<CustomerDto>> getCustomerById(@PathVariable Integer id) {

       ResponseGeneric<CustomerDto> customerDtoCustomResponse;
       try {
           CustomerDto customerDto=customerService.getById(id);
           customerDtoCustomResponse = ResponseGeneric.<CustomerDto>builder()
                   .Dto(customerDto)
                   .errorMessage("")
                   .responseStatus(ResponseStatus.Ok)
                   .build();

       }catch (NotFoundException e)
       {
           customerDtoCustomResponse = ResponseGeneric.<CustomerDto>builder()
                   .errorMessage(e.getMessage())
                   .responseStatus(ResponseStatus.Ko)
                   .build();
       }
        return ResponseEntity.ok(customerDtoCustomResponse);

    }

}
