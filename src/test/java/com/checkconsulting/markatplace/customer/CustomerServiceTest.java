package com.checkconsulting.markatplace.customer;

import com.checkconsulting.markatplace.entity.Customer;
import com.checkconsulting.markatplace.modelDto.CustomerDto;
import com.checkconsulting.markatplace.repository.CustomerRepository;
import com.checkconsulting.markatplace.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void itShouldReturnCustomerById(){
        //given
        Customer customer =Customer.builder()
                .id(1)
                .firstname("lahcene")
                .lastname("makour")
                .username("lmakour")
                .amount(200F)
                .build();

        Mockito.when(customerRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(customer));

        //when
        CustomerService customerService =new CustomerService(customerRepository);
        CustomerDto customer1 = customerService.getById(1);

        //then
        Assertions.assertEquals(customer1.getFirstname(),"lahcene");
        Assertions.assertEquals(customer1.getUsername(),"lmakour");
        Assertions.assertEquals(customer1.getLastname(),"makour");
        Assertions.assertEquals(customer1.getAmount(),200F);

    }
}
