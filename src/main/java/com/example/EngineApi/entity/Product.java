package com.example.EngineApi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productNameKa;  // Georgian name

    private String productNameEn;  // English name

    private Double price;

    private String description;

    private String productLogo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "branch_id")
    private Branch branch;

    // Getters and Setters


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNameKa() {
        return productNameKa;
    }

    public void setProductNameKa(String productNameKa) {
        this.productNameKa = productNameKa;
    }

    public String getProductNameEn() {
        return productNameEn;
    }

    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
