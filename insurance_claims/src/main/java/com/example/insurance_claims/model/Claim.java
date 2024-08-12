package com.example.insurance_claims.model;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @ManyToOne
    @JoinColumn(name = "policyId", nullable = false)
    private Policy policy;

    @ManyToOne
    @JoinColumn(name = "insuredId", nullable = false)
    private Insured insured;

    @ManyToOne
    @JoinColumn(name = "incidentId", nullable = false)
    private Incident incident;

    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false)
    private Vehicle vehicle;

    private Character fraudReported;
    private String additionalInfo;
    private BigDecimal totalClaimAmount;

    // Getters and setters
}
