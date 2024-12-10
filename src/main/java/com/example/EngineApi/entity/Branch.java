package com.example.EngineApi.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    private String branchNameKa;  // Georgian name

    private String branchNameEn;  // English name

    private String descriptionKa; // Georgian description

    private String descriptionEn; // English description

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    // Getters and Setters

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getBranchNameKa() {
        return branchNameKa;
    }

    public void setBranchNameKa(String branchNameKa) {
        this.branchNameKa = branchNameKa;
    }

    public String getBranchNameEn() {
        return branchNameEn;
    }

    public void setBranchNameEn(String branchNameEn) {
        this.branchNameEn = branchNameEn;
    }

    public String getDescriptionKa() {
        return descriptionKa;
    }

    public void setDescriptionKa(String descriptionKa) {
        this.descriptionKa = descriptionKa;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
