package com.example.EngineApi.dto;

import com.example.EngineApi.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class BranchDto {
    private String branchNameKa;  // Georgian name
    private String branchNameEn;  // English name
    private String descriptionKa; // Georgian description
    private String descriptionEn; // English description


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
}
