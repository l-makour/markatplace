package com.checkconsulting.markatplace.product;

import com.checkconsulting.markatplace.entity.Product;
import com.checkconsulting.markatplace.modelDto.ProductDto;
import com.checkconsulting.markatplace.repository.ProductRepository;
import com.checkconsulting.markatplace.service.ProductService;
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
    public void itShouldReturnProductById(){
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
