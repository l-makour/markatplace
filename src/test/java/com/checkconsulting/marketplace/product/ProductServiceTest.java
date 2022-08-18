package com.checkconsulting.marketplace.product;

import com.checkconsulting.marketplace.entity.Product;
import com.checkconsulting.marketplace.exceptions.NotFoundException;
import com.checkconsulting.marketplace.modelDto.ProductDto;
import com.checkconsulting.marketplace.repository.ProductRepository;
import com.checkconsulting.marketplace.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    public void itShouldReturnProductById() throws NotFoundException {
        //given
        Product product =Product.builder()
                .id(1)
                .name("clavier")
                .price(12)
                .build();

        Mockito.when(productRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(product));

        //when
        ProductService productService =new ProductService(productRepository);
        ProductDto product1 = productService.getById(1);

        //then
        Assertions.assertEquals(product1.getName(),"clavier");
        Assertions.assertEquals(product1.getPrice(),12);

    }
}
