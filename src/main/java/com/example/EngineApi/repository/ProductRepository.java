package com.example.EngineApi.repository;

import com.example.EngineApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can still define other query methods here if needed
}
