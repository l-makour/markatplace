package com.checkconsulting.marketplace.controller;
import com.checkconsulting.marketplace.enums.ResponseStatus;
import com.checkconsulting.marketplace.exceptions.NotFoundException;
import com.checkconsulting.marketplace.modelDto.ProductDto;
import com.checkconsulting.marketplace.service.ProductService;
import com.checkconsulting.marketplace.utils.ResponseGeneric;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ResponseGeneric<ProductDto>> getProductById(@PathVariable Integer id) {
        ResponseGeneric<ProductDto> responseGeneric;
        try {
            ProductDto productDto = productService.getById(id);
            responseGeneric = ResponseGeneric.<ProductDto>builder()
                    .Dto(productDto)
                    .errorMessage("")
                    .responseStatus(ResponseStatus.Ok)
                    .build();

        } catch (NotFoundException e) {
            responseGeneric = ResponseGeneric.<ProductDto>builder()
                    .errorMessage(e.getMessage())
                    .responseStatus(ResponseStatus.Ko)
                    .build();
        }
        return ResponseEntity.ok(responseGeneric);

    }
}
