package com.example.insurance_claims.model;

import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyid")
    private Long policyId;

    @Column(name = "policynumber")
    private Integer policyNumber;

    @Column(name = "policybinddate")
    private Date policyBindDate;

    @Column(name = "policystate", length = 2)
    private String policyState;

    @Column(name = "policycsl", length = 10)
    private String policyCsl;

    @Column(name = "policydeductible")
    private Integer policyDeductible;

    @Column(name = "policyannualpremium")
    private BigDecimal policyAnnualPremium;

    @Column(name = "umbrellalimit")
    private Integer umbrellaLimit;

    // No-args constructor
    public Policy() {}

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getPolicyBindDate() {
        return policyBindDate;
    }

    public void setPolicyBindDate(Date policyBindDate) {
        this.policyBindDate = policyBindDate;
    }

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState;
    }

    public String getPolicyCsl() {
        return policyCsl;
    }

    public void setPolicyCsl(String policyCsl) {
        this.policyCsl = policyCsl;
    }

    public Integer getPolicyDeductible() {
        return policyDeductible;
    }

    public void setPolicyDeductible(Integer policyDeductible) {
        this.policyDeductible = policyDeductible;
    }

    public BigDecimal getPolicyAnnualPremium() {
        return policyAnnualPremium;
    }

    public void setPolicyAnnualPremium(BigDecimal policyAnnualPremium) {
        this.policyAnnualPremium = policyAnnualPremium;
    }

    public Integer getUmbrellaLimit() {
        return umbrellaLimit;
    }

    public void setUmbrellaLimit(Integer umbrellaLimit) {
        this.umbrellaLimit = umbrellaLimit;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyNumber=" + policyNumber +
                ", policyBindDate=" + policyBindDate +
                ", policyState='" + policyState + '\'' +
                ", policyCsl='" + policyCsl + '\'' +
                ", policyDeductible=" + policyDeductible +
                ", policyAnnualPremium=" + policyAnnualPremium +
                ", umbrellaLimit=" + umbrellaLimit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyId, policy.policyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyId);
    }
}
