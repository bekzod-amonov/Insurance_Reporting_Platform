package com.example.insurance_claims.controller;

import com.example.insurance_claims.model.InsuredClaim;
import com.example.insurance_claims.service.InsuredClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insured-claims")
public class InsuredClaimController {

    @Autowired
    private InsuredClaimService insuredClaimService;

    @GetMapping
    public List<InsuredClaim> getAllInsuredClaims() {
        return insuredClaimService.getAllInsuredClaims();
    }

    @GetMapping("/{id}")
    public InsuredClaim getInsuredClaimById(@PathVariable Long id) {
        return insuredClaimService.getInsuredClaimById(id);
    }

    @PostMapping
    public InsuredClaim createInsuredClaim(@RequestBody InsuredClaim insuredClaim) {
        return insuredClaimService.saveInsuredClaim(insuredClaim);
    }

    @PutMapping("/{id}")
    public InsuredClaim updateInsuredClaim(@PathVariable Long id, @RequestBody InsuredClaim insuredClaim) {
        insuredClaim.setInsuredClaimId(id);
        return insuredClaimService.saveInsuredClaim(insuredClaim);
    }

    @DeleteMapping("/{id}")
    public void deleteInsuredClaim(@PathVariable Long id) {
        insuredClaimService.deleteInsuredClaim(id);
    }
}

