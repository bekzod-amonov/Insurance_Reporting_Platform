package com.example.insurance_claims.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "InsuredClaims")
public class InsuredClaim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuredClaimId;

    private Integer monthsAsCustomer;
    private Integer age;
    private Integer policyNumber;
    private Date policyBindDate;
    private String policyState;
    private String policyCSL;
    private Integer policyDeductible;
    private Double policyAnnualPremium;
    private Integer umbrellaLimit;
    private Integer insuredZip;
    private String insuredSex;
    private String insuredEducationLevel;
    private String insuredOccupation;
    private String insuredHobbies;
    private String insuredRelationship;
    private Integer capitalGains;
    private Integer capitalLoss;
    private Date incidentDate;
    private String incidentType;
    private String collisionType;
    private String incidentSeverity;
    private String authoritiesContacted;
    private String incidentState;
    private String incidentCity;
    private String incidentLocation;
    private Integer incidentHourOfTheDay;
    private Integer numberOfVehiclesInvolved;
    private String propertyDamage;
    private Integer bodilyInjuries;
    private Integer witnesses;
    private String policeReportAvailable;
    private Integer totalClaimAmount;
    private Integer injuryClaim;
    private Integer propertyClaim;
    private Integer vehicleClaim;
    private String autoMake;
    private String autoModel;
    private Integer autoYear;
    private String fraudReported;
    private String additionalInfo;

    // Getters and Setters
    public Long getInsuredClaimId() {
        return insuredClaimId;
    }

    public void setInsuredClaimId(Long insuredClaimId) {
        this.insuredClaimId = insuredClaimId;
    }

    public Integer getMonthsAsCustomer() {
        return monthsAsCustomer;
    }

    public void setMonthsAsCustomer(Integer monthsAsCustomer) {
        this.monthsAsCustomer = monthsAsCustomer;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getPolicyCSL() {
        return policyCSL;
    }

    public void setPolicyCSL(String policyCSL) {
        this.policyCSL = policyCSL;
    }

    public Integer getPolicyDeductible() {
        return policyDeductible;
    }

    public void setPolicyDeductible(Integer policyDeductible) {
        this.policyDeductible = policyDeductible;
    }

    public Double getPolicyAnnualPremium() {
        return policyAnnualPremium;
    }

    public void setPolicyAnnualPremium(Double policyAnnualPremium) {
        this.policyAnnualPremium = policyAnnualPremium;
    }

    public Integer getUmbrellaLimit() {
        return umbrellaLimit;
    }

    public void setUmbrellaLimit(Integer umbrellaLimit) {
        this.umbrellaLimit = umbrellaLimit;
    }

    public Integer getInsuredZip() {
        return insuredZip;
    }

    public void setInsuredZip(Integer insuredZip) {
        this.insuredZip = insuredZip;
    }

    public String getInsuredSex() {
        return insuredSex;
    }

    public void setInsuredSex(String insuredSex) {
        this.insuredSex = insuredSex;
    }

    public String getInsuredEducationLevel() {
        return insuredEducationLevel;
    }

    public void setInsuredEducationLevel(String insuredEducationLevel) {
        this.insuredEducationLevel = insuredEducationLevel;
    }

    public String getInsuredOccupation() {
        return insuredOccupation;
    }

    public void setInsuredOccupation(String insuredOccupation) {
        this.insuredOccupation = insuredOccupation;
    }

    public String getInsuredHobbies() {
        return insuredHobbies;
    }

    public void setInsuredHobbies(String insuredHobbies) {
        this.insuredHobbies = insuredHobbies;
    }

    public String getInsuredRelationship() {
        return insuredRelationship;
    }

    public void setInsuredRelationship(String insuredRelationship) {
        this.insuredRelationship = insuredRelationship;
    }

    public Integer getCapitalGains() {
        return capitalGains;
    }

    public void setCapitalGains(Integer capitalGains) {
        this.capitalGains = capitalGains;
    }

    public Integer getCapitalLoss() {
        return capitalLoss;
    }

    public void setCapitalLoss(Integer capitalLoss) {
        this.capitalLoss = capitalLoss;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getCollisionType() {
        return collisionType;
    }

    public void setCollisionType(String collisionType) {
        this.collisionType = collisionType;
    }

    public String getIncidentSeverity() {
        return incidentSeverity;
    }

    public void setIncidentSeverity(String incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }

    public String getAuthoritiesContacted() {
        return authoritiesContacted;
    }

    public void setAuthoritiesContacted(String authoritiesContacted) {
        this.authoritiesContacted = authoritiesContacted;
    }

    public String getIncidentState() {
        return incidentState;
    }

    public void setIncidentState(String incidentState) {
        this.incidentState = incidentState;
    }

    public String getIncidentCity() {
        return incidentCity;
    }

    public void setIncidentCity(String incidentCity) {
        this.incidentCity = incidentCity;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public Integer getIncidentHourOfTheDay() {
        return incidentHourOfTheDay;
    }

    public void setIncidentHourOfTheDay(Integer incidentHourOfTheDay) {
        this.incidentHourOfTheDay = incidentHourOfTheDay;
    }

    public Integer getNumberOfVehiclesInvolved() {
        return numberOfVehiclesInvolved;
    }

    public void setNumberOfVehiclesInvolved(Integer numberOfVehiclesInvolved) {
        this.numberOfVehiclesInvolved = numberOfVehiclesInvolved;
    }

    public String getPropertyDamage() {
        return propertyDamage;
    }

    public void setPropertyDamage(String propertyDamage) {
        this.propertyDamage = propertyDamage;
    }

    public Integer getBodilyInjuries() {
        return bodilyInjuries;
    }

    public void setBodilyInjuries(Integer bodilyInjuries) {
        this.bodilyInjuries = bodilyInjuries;
    }

    public Integer getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(Integer witnesses) {
        this.witnesses = witnesses;
    }

    public String getPoliceReportAvailable() {
        return policeReportAvailable;
    }

    public void setPoliceReportAvailable(String policeReportAvailable) {
        this.policeReportAvailable = policeReportAvailable;
    }

    public Integer getTotalClaimAmount() {
        return totalClaimAmount;
    }

    public void setTotalClaimAmount(Integer totalClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
    }

    public Integer getInjuryClaim() {
        return injuryClaim;
    }

    public void setInjuryClaim(Integer injuryClaim) {
        this.injuryClaim = injuryClaim;
    }

    public Integer getPropertyClaim() {
        return propertyClaim;
    }

    public void setPropertyClaim(Integer propertyClaim) {
        this.propertyClaim = propertyClaim;
    }

    public Integer getVehicleClaim() {
        return vehicleClaim;
    }

    public void setVehicleClaim(Integer vehicleClaim) {
        this.vehicleClaim = vehicleClaim;
    }

    public String getAutoMake() {
        return autoMake;
    }

    public void setAutoMake(String autoMake) {
        this.autoMake = autoMake;
    }

    public String getAutoModel() {
        return autoModel;
    }

    public void setAutoModel(String autoModel) {
        this.autoModel = autoModel;
    }

    public Integer getAutoYear() {
        return autoYear;
    }

    public void setAutoYear(Integer autoYear) {
        this.autoYear = autoYear;
    }

    public String getFraudReported() {
        return fraudReported;
    }

    public void setFraudReported(String fraudReported) {
        this.fraudReported = fraudReported;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}

