package com.example.EngineApi.services.impl;

import com.example.EngineApi.dto.ProductsDto;
import com.example.EngineApi.entity.Branch;
import com.example.EngineApi.entity.Product;
import com.example.EngineApi.repository.BranchRepository;
import com.example.EngineApi.repository.ProductRepository;
import com.example.EngineApi.services.BranchService;
import com.example.EngineApi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchService branchService;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByBranchId(Long branchId) {
        Branch ex = branchService.getBranchById(branchId);
        List<Product> ans = ex.getProducts();
        return ans; //custom
    }

    @Override
    public Product updateProduct(Long productId, ProductsDto productData) {
        Optional<Product> existingProduct = productRepository.findById(productId);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setProductNameEn(productData.getProductNameEn());
            product.setProductNameKa(productData.getProductNameKa());
            product.setPrice(productData.getPrice());
            product.setDescription(productData.getDescription());
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found with ID: " + productId);
    }
    @Override
    public void deleteProduct(Long Id){
        productRepository.deleteById(Id);
    }

    @Override
    public boolean removeProduct(Long productId, String logoPath) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        }
        return false;
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id); //
        return product.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product addProduct(Long branch_id, ProductsDto productData) {
        Branch exBranch =  branchService.getBranchById(branch_id);

        Product newProduct = new Product();
        newProduct.setProductNameKa(productData.getProductNameKa());
        newProduct.setProductNameEn(productData.getProductNameEn());
        newProduct.setPrice(productData.getPrice());
        newProduct.setProductLogo(productData.getProductLogo());
        newProduct.setBranch(exBranch);

        return productRepository.save(newProduct);
    }

    @Override
    public boolean changeProductLogo(String NewLogo, Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
            Product product = productOpt.get();
            product.setProductLogo(NewLogo);
            productRepository.save(product);

            return true;
    }
}