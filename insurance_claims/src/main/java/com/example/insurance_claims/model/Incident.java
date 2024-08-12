package com.example.insurance_claims.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

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

    // Getters and Setters
    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
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
}
