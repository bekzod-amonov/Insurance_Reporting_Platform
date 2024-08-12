package com.example.insurance_claims.service;

import com.example.insurance_claims.model.KPIResult;
import com.example.insurance_claims.repository.KPIResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIService {

    @Autowired
    private KPIResultRepository kpiResultRepository;

    public List<KPIResult> getAllKPIResults() {
        return kpiResultRepository.findAll();
    }

    public KPIResult getKPIResultByPolicyId(Long policyId) {
        return kpiResultRepository.findById(policyId).orElse(null);
    }
}
