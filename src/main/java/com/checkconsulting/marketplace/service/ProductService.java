package com.checkconsulting.marketplace.service;

import com.checkconsulting.marketplace.entity.Product;
import com.checkconsulting.marketplace.modelDto.ProductDto;
import com.checkconsulting.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAll() {

        return productRepository.findAll().stream()
                .map(product -> mapToProductDto(product))
                .collect(Collectors.toList());
    }

    public ProductDto getById(Integer id) {
        if(productRepository.findById(id).isPresent())
            return mapToProductDto(productRepository.findById(id).get());
        else return null;
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}

