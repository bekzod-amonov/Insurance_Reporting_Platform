package com.example.insurance_claims.controller;

import com.example.insurance_claims.model.KPIResult;
import com.example.insurance_claims.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kpis")
public class KPIController {

    @Autowired
    private KPIService kpiService;

    @GetMapping
    public List<KPIResult> getAllKPIResults() {
        return kpiService.getAllKPIResults();
    }

    @GetMapping("/{policyId}")
    public KPIResult getKPIResultByPolicyId(@PathVariable Long policyId) {
        return kpiService.getKPIResultByPolicyId(policyId);
    }
}