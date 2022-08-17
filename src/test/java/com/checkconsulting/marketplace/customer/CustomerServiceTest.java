package com.checkconsulting.marketplace.customer;

import com.checkconsulting.marketplace.entity.Customer;
import com.checkconsulting.marketplace.exceptions.CustomerNotFoundException;
import com.checkconsulting.marketplace.modelDto.CustomerDto;
import com.checkconsulting.marketplace.repository.CustomerRepository;
import com.checkconsulting.marketplace.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void itShouldReturnCustomerById() throws CustomerNotFoundException {
        //given
        Customer customer =Customer.builder()
                .id(1)
                .firstname("lahcene")
                .lastname("makour")
                .username("lmakour")
                .amount(200F)
                .build();

        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        //when
        CustomerService customerService =new CustomerService(customerRepository);
        CustomerDto customer1 = customerService.getById(1);

        //then
        Assertions.assertEquals(customer1.getFirstname(),"lahcene");
        Assertions.assertEquals(customer1.getUsername(),"lmakour");
        Assertions.assertEquals(customer1.getLastname(),"makour");
        Assertions.assertEquals(customer1.getAmount(),200F);
    }

    @Test
    public void itShouldReturnCustomerByIdNotFound() throws CustomerNotFoundException {
        //given
        Customer customer =Customer.builder()
                .id(1)
                .firstname("lahcene")
                .lastname("makour")
                .username("lmakour")
                .amount(200F)
                .build();

        Mockito.when(customerRepository.findById(2)).thenReturn(Optional.empty());

        //when
        CustomerService customerService =new CustomerService(customerRepository);
        CustomerNotFoundException exception= Assertions.assertThrows(CustomerNotFoundException.class,()->customerService.getById(2));

        //then
        Assertions.assertEquals(exception.getMessage(),"Customer id 3 not fount");
    }

}
