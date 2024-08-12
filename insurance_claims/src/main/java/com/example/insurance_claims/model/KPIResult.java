package com.example.insurance_claims.model;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.math.BigDecimal;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "kpiresults")
public class KPIResult {
    @Id
    @Column(name = "policyid")
    private Long policyId;

    @Column(name = "pvfp")
    private BigDecimal pvfp;

    @Column(name = "vnb")
    private BigDecimal vnb;

    @Column(name = "scr")
    private BigDecimal scr;

    // Getters and Setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public BigDecimal getPvfp() {
        return pvfp;
    }

    public void setPvfp(BigDecimal pvfp) {
        this.pvfp = pvfp;
    }

    public BigDecimal getVnb() {
        return vnb;
    }

    public void setVnb(BigDecimal vnb) {
        this.vnb = vnb;
    }

    public BigDecimal getScr() {
        return scr;
    }

    public void setScr(BigDecimal scr) {
        this.scr = scr;
    }
}


