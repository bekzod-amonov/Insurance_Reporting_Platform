package com.example.insurance_claims.model;

//import javax.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Insured")
public class Insured {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuredId;

    private Integer insuredZip;
    private String insuredSex;
    private String insuredEducationLevel;
    private String insuredOccupation;
    private String insuredHobbies;
    private String insuredRelationship;
    private Integer capitalGains;
    private Integer capitalLoss;

    // Getters and Setters
    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
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
}
