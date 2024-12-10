package com.example.EngineApi.services;

import com.example.EngineApi.dto.BranchDto;
import com.example.EngineApi.entity.Branch;
import java.util.List;

public interface BranchService {
    List<Branch> getAllBranches();
    Branch getBranchById(Long id);
    Branch addBranch(BranchDto branch);
    Branch updateBranch(Long id, BranchDto branch);
    void deleteBranch(Long id);
}
