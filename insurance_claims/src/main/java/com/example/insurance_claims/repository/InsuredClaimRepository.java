package com.example.insurance_claims.repository;

import com.example.insurance_claims.model.InsuredClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredClaimRepository extends JpaRepository<InsuredClaim, Long> {
}
