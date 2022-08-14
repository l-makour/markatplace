package com.checkconsulting.markatplace;

import com.checkconsulting.markatplace.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = MarkatplaceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTestIT {
    @LocalServerPort
    Integer port;
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void itShouldReturnAllProducts(){
        Product[] products= restTemplate.getForObject("http://localhost:"+port+"/api/v1/products", Product[].class);
        Assertions.assertTrue(products.length==4);
    }
}
