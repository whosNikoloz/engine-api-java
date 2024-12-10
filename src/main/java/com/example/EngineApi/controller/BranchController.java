package com.example.EngineApi.controller;

import com.example.EngineApi.dto.BranchDto;
import com.example.EngineApi.entity.ApiResponse;
import com.example.EngineApi.entity.Branch;
import com.example.EngineApi.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public ResponseEntity<?> getAllBranches() {
        try {
            List<Branch> branches = branchService.getAllBranches();
            return ResponseEntity.ok(new ApiResponse(true, branches));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error retrieving branches."));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBranchById(@PathVariable Long id) {
        try {
            Branch branch = branchService.getBranchById(id);
            if (branch != null) {
                return ResponseEntity.ok(new ApiResponse(true, branch));
            } else {
                return ResponseEntity.status(404).body(new ApiResponse(false, "Branch not found."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error retrieving branch."));
        }
    }

    @PostMapping
    public ResponseEntity<?> addBranch(@RequestBody BranchDto newBranch) {
        try {
            Branch branch = branchService.addBranch(newBranch);
            return ResponseEntity.ok(new ApiResponse(true, branch));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, e));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBranch(@PathVariable Long id, @RequestBody BranchDto updatedBranch) {
        try {
            Branch branch = branchService.updateBranch(id, updatedBranch);
            if (branch != null) {
                return ResponseEntity.ok(new ApiResponse(true, "Branch updated successfully."));
            } else {
                return ResponseEntity.status(404).body(new ApiResponse(false, "Branch not found."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error updating branch."));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable Long id) {
        try {
            branchService.deleteBranch(id);
            return ResponseEntity.ok(new ApiResponse(true, "Branch deleted successfully."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error deleting branch."));
        }
    }
}
