package com.checkconsulting.marketplace.customer;

import com.checkconsulting.marketplace.MarkatplaceApplication;
import com.checkconsulting.marketplace.entity.Customer;
import com.checkconsulting.marketplace.enums.ResponseStatus;
import com.checkconsulting.marketplace.utils.CustomResponse;
import com.checkconsulting.marketplace.modelDto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@SpringBootTest(classes = MarkatplaceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTestIT {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void itShouldReturnAllCustomers() {

        Customer[] customers = restTemplate.getForObject("http://localhost:" + port + "/api/v1/customers", Customer[].class);
        Assertions.assertTrue(customers.length == 4);
    }

    @Test
    public void itShouldReturnCustomerById() {
        String url = "http://localhost:" + port + "/api/v1/customer/1";
        CustomResponse<CustomerDto> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<CustomResponse<CustomerDto>>() {}).getBody();
        Assertions.assertEquals(response.getResponseStatus(), ResponseStatus.Ok);
        Assertions.assertEquals(response.getErrorMessage(), "");
        Assertions.assertEquals(response.getCustomDto().getId(), 1);

        String url1 = "http://localhost:" + port + "/api/v1/customer/6";
        CustomResponse<CustomerDto> response1 = restTemplate.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<CustomResponse<CustomerDto>>() {}).getBody();
        Assertions.assertEquals(response1.getResponseStatus(), ResponseStatus.Ko);
        Assertions.assertEquals(response1.getErrorMessage(), "Customer id 6 not fount");
        Assertions.assertNull(response1.getCustomDto());

    }
}
