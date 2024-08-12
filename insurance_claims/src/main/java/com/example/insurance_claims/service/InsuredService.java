package com.example.insurance_claims.service;

import com.example.insurance_claims.model.Insured;
import com.example.insurance_claims.repository.InsuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuredService {
    @Autowired
    private InsuredRepository insuredRepository;

    public List<Insured> getAllInsured() {
        return insuredRepository.findAll();
    }

    public Insured getInsuredById(Long id) {
        return insuredRepository.findById(id).orElse(null);
    }

    public Insured saveInsured(Insured insured) {
        return insuredRepository.save(insured);
    }

    public void deleteInsured(Long id) {
        insuredRepository.deleteById(id);
    }
}

