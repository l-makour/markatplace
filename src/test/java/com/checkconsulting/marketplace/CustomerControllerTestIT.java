package com.checkconsulting.marketplace;

import com.checkconsulting.marketplace.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = MarkatplaceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTestIT {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate restTemplate;
    @Test
    public void itShouldReturnAllCustomers(){

        Customer[] customers=restTemplate.getForObject("http://localhost:"+port+"/api/v1/customers",Customer[].class);
        Assertions.assertTrue(customers.length==4);
    }
}
