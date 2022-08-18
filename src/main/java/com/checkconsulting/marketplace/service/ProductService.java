package com.checkconsulting.marketplace.service;

import com.checkconsulting.marketplace.entity.Customer;
import com.checkconsulting.marketplace.entity.Product;
import com.checkconsulting.marketplace.exceptions.NotFoundException;
import com.checkconsulting.marketplace.modelDto.ProductDto;
import com.checkconsulting.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ProductDto getById(Integer id) throws NotFoundException {
        Optional<Product> product =productRepository.findById(id);
        if(product.isPresent())
            return mapToProductDto(productRepository.findById(id).get());
        throw new NotFoundException("Customer id "+id+" not fount");
    }

    public ProductDto mapToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}

