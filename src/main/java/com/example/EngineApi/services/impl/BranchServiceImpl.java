package com.example.EngineApi.services.impl;

import com.example.EngineApi.dto.BranchDto;
import com.example.EngineApi.entity.Branch;
import com.example.EngineApi.repository.BranchRepository;
import com.example.EngineApi.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    @Override
    public Branch addBranch(BranchDto branchDto) {
        Branch newBranch = new Branch();
        newBranch.setBranchNameKa(branchDto.getBranchNameKa());
        newBranch.setBranchNameEn(branchDto.getBranchNameEn());
        newBranch.setDescriptionKa(branchDto.getDescriptionKa());
        newBranch.setDescriptionEn(branchDto.getDescriptionEn());
        return branchRepository.save(newBranch);
    }


    @Override
    public Branch updateBranch(Long id, BranchDto updatedBranch) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()) {
            Branch branch = optionalBranch.get();
            branch.setBranchNameKa(updatedBranch.getBranchNameKa());
            branch.setBranchNameEn(updatedBranch.getBranchNameEn());
            branch.setDescriptionKa(updatedBranch.getDescriptionKa());
            branch.setDescriptionEn(updatedBranch.getDescriptionEn());
            branchRepository.save(branch);
            return branch;
        }
        return null;
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
