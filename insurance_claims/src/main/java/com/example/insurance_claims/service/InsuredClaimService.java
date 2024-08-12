package com.example.insurance_claims.service;

import com.example.insurance_claims.model.InsuredClaim;
import com.example.insurance_claims.repository.InsuredClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredClaimService {
    @Autowired
    private InsuredClaimRepository insuredClaimRepository;

    public List<InsuredClaim> getAllInsuredClaims() {
        return insuredClaimRepository.findAll();
    }

    public InsuredClaim getInsuredClaimById(Long id) {
        return insuredClaimRepository.findById(id).orElse(null);
    }

    public InsuredClaim saveInsuredClaim(InsuredClaim insuredClaim) {
        return insuredClaimRepository.save(insuredClaim);
    }

    public void deleteInsuredClaim(Long id) {
        insuredClaimRepository.deleteById(id);
    }
}

