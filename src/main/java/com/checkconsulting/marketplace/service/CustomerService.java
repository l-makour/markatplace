package com.checkconsulting.marketplace.service;

import com.checkconsulting.marketplace.entity.Customer;
import com.checkconsulting.marketplace.modelDto.CustomerDto;
import com.checkconsulting.marketplace.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAll() {

        return customerRepository.findAll().stream()
                .map(customer -> mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    public CustomerDto mapToCustomerDto(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .amount(customer.getAmount())
                .build();
    }
}
