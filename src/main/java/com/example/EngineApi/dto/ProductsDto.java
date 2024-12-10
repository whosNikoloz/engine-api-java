package com.example.EngineApi.dto;

import com.example.EngineApi.entity.Branch;
import jakarta.persistence.*;

public class ProductsDto {

    private String productNameKa;  // Georgian name
    private String productNameEn;  // English name
    private Double price;
    private String description;
    private String productLogo;

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
}
