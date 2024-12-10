package com.example.EngineApi.controller;

import com.example.EngineApi.dto.ProductsDto;
import com.example.EngineApi.entity.ApiResponse;
import com.example.EngineApi.entity.Product;
import com.example.EngineApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products = productService.getProducts();
            return ResponseEntity.ok(new ApiResponse(true, products));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, e));
        }
    }

    @GetMapping("/{branch_id}")
    public ResponseEntity<?> getProductsByBranch(@PathVariable Long branch_id) {
        try {
            List<Product> products = productService.getProductsByBranchId(branch_id);
            return ResponseEntity.ok(new ApiResponse(true, products));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, e));
        }
    }

    @PostMapping("/{branch_id}")
    public ResponseEntity<?> createProduct(@PathVariable Long branch_id, @RequestBody ProductsDto newProduct) {
        try {
            Product product = productService.addProduct(branch_id,newProduct);
            return ResponseEntity.ok(new ApiResponse(true, product));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, e));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductsDto newProduct) {
        try {
            Product product = productService.updateProduct(id,newProduct);
            return ResponseEntity.ok(new ApiResponse(true, product));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok(new ApiResponse(true, "Product deleted successfully."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error deleting branch."));
        }
    }
}