package com.example.insurance_claims.controller;

import com.example.insurance_claims.model.Insured;
import com.example.insurance_claims.service.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insured")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping
    public List<Insured> getAllInsured() {
        return insuredService.getAllInsured();
    }

    @GetMapping("/{id}")
    public Insured getInsuredById(@PathVariable Long id) {
        return insuredService.getInsuredById(id);
    }

    @PostMapping
    public Insured createInsured(@RequestBody Insured insured) {
        return insuredService.saveInsured(insured);
    }

    @PutMapping("/{id}")
    public Insured updateInsured(@PathVariable Long id, @RequestBody Insured insured) {
        insured.setInsuredId(id);
        return insuredService.saveInsured(insured);
    }

    @DeleteMapping("/{id}")
    public void deleteInsured(@PathVariable Long id) {
        insuredService.deleteInsured(id);
    }
}

