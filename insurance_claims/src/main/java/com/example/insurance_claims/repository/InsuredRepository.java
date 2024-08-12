package com.example.insurance_claims.repository;

import com.example.insurance_claims.model.Insured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<Insured, Long> {
}

