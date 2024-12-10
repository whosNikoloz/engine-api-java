package com.example.EngineApi.services;

import com.example.EngineApi.dto.ProductsDto;
import com.example.EngineApi.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<Product> getProductsByBranchId(Long branchId);

    Product updateProduct(Long productId, ProductsDto productData);

    boolean removeProduct(Long productId, String logoPath);

    Product getProduct(Long Id);

    void deleteProduct(Long Id);

    Product addProduct(Long branch_id, ProductsDto productData);

    boolean changeProductLogo(String NewLogo, Long productId);
}
