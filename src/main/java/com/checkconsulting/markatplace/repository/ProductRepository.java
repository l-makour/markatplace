package com.checkconsulting.markatplace.repository;

import com.checkconsulting.markatplace.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
