CREATE TABLE insurance_claims (
    months_as_customer INTEGER,
    age INTEGER,
    policy_number INTEGER,
    policy_bind_date DATE,
    policy_state VARCHAR(2),
    policy_csl VARCHAR(10),
    policy_deductable INTEGER,
    policy_annual_premium NUMERIC(10, 2),
    umbrella_limit INTEGER,
    insured_zip INTEGER,
    insured_sex VARCHAR(10),
    insured_education_level VARCHAR(20),
    insured_occupation VARCHAR(50),
    insured_hobbies VARCHAR(50),
    insured_relationship VARCHAR(20),
    capital_gains INTEGER,
    capital_loss INTEGER,
    incident_date DATE,
    incident_type VARCHAR(50),
    collision_type VARCHAR(50),
    incident_severity VARCHAR(20),
    authorities_contacted VARCHAR(20),
    incident_state VARCHAR(2),
    incident_city VARCHAR(50),
    incident_location VARCHAR(100),
    incident_hour_of_the_day INTEGER,
    number_of_vehicles_involved INTEGER,
    property_damage VARCHAR(3),
    bodily_injuries INTEGER,
    witnesses INTEGER,
    police_report_available VARCHAR(3),
    total_claim_amount INTEGER,
    injury_claim INTEGER,
    property_claim INTEGER,
    vehicle_claim INTEGER,
    auto_make VARCHAR(20),
    auto_model VARCHAR(20),
    auto_year INTEGER,
    fraud_reported CHAR(1),
    _c39 VARCHAR(10)
);

COPY insurance_claims FROM 'C:\insurance_claims_project/insurance_claims.csv' WITH CSV HEADER


-- Create Policies Table
CREATE TABLE Policies (
    PolicyID SERIAL PRIMARY KEY,
    PolicyNumber INTEGER NOT NULL,
    PolicyBindDate DATE NOT NULL,
    PolicyState VARCHAR(2) NOT NULL,
    PolicyCSL VARCHAR(10) NOT NULL,
    PolicyDeductible INTEGER NOT NULL,
    PolicyAnnualPremium NUMERIC(10, 2) NOT NULL,
    UmbrellaLimit INTEGER NOT NULL
);

-- Create Insured Table
CREATE TABLE Insured (
    InsuredID SERIAL PRIMARY KEY,
    InsuredZip INTEGER NOT NULL,
    InsuredSex VARCHAR(10) NOT NULL,
    InsuredEducationLevel VARCHAR(20) NOT NULL,
    InsuredOccupation VARCHAR(50) NOT NULL,
    InsuredHobbies VARCHAR(50) NOT NULL,
    InsuredRelationship VARCHAR(20) NOT NULL,
    CapitalGains INTEGER NOT NULL,
    CapitalLoss INTEGER NOT NULL
);

-- Create Incidents Table
CREATE TABLE Incidents (
    IncidentID SERIAL PRIMARY KEY,
    IncidentDate DATE NOT NULL,
    IncidentType VARCHAR(50) NOT NULL,
    CollisionType VARCHAR(50),
    IncidentSeverity VARCHAR(20) NOT NULL,
    AuthoritiesContacted VARCHAR(20) NOT NULL,
    IncidentState VARCHAR(2) NOT NULL,
    IncidentCity VARCHAR(50) NOT NULL,
    IncidentLocation VARCHAR(100) NOT NULL,
    IncidentHourOfTheDay INTEGER NOT NULL,
    NumberOfVehiclesInvolved INTEGER NOT NULL,
    PropertyDamage VARCHAR(3),
    BodilyInjuries INTEGER NOT NULL,
    Witnesses INTEGER,
    PoliceReportAvailable VARCHAR(3) NOT NULL,
    TotalClaimAmount INTEGER NOT NULL,
    InjuryClaim INTEGER NOT NULL,
    PropertyClaim INTEGER NOT NULL,
    VehicleClaim INTEGER NOT NULL
);

-- Create Vehicles Table
CREATE TABLE Vehicles (
    VehicleID SERIAL PRIMARY KEY,
    AutoMake VARCHAR(20) NOT NULL,
    AutoModel VARCHAR(20) NOT NULL,
    AutoYear INTEGER NOT NULL
);

-- Create Claims Table
CREATE TABLE Claims (
    ClaimID SERIAL PRIMARY KEY,
    PolicyID INT NOT NULL REFERENCES Policies(PolicyID),
    InsuredID INT NOT NULL REFERENCES Insured(InsuredID),
    IncidentID INT NOT NULL REFERENCES Incidents(IncidentID),
    VehicleID INT NOT NULL REFERENCES Vehicles(VehicleID),
    FraudReported CHAR(1) NOT NULL,
    AdditionalInfo VARCHAR(10)
);

-- Insert Data into Policies Table
INSERT INTO Policies (PolicyNumber, PolicyBindDate, PolicyState, PolicyCSL, PolicyDeductible, PolicyAnnualPremium, UmbrellaLimit)
SELECT policy_number, policy_bind_date, policy_state, policy_csl, policy_deductable, policy_annual_premium, umbrella_limit
FROM insurance_claims;

-- Insert Data into Insured Table
INSERT INTO Insured (InsuredZip, InsuredSex, InsuredEducationLevel, InsuredOccupation, InsuredHobbies, InsuredRelationship, CapitalGains, CapitalLoss)
SELECT insured_zip, insured_sex, insured_education_level, insured_occupation, insured_hobbies, insured_relationship, capital_gains, capital_loss
FROM insurance_claims;

-- Insert Data into Incidents Table
INSERT INTO Incidents (IncidentDate, IncidentType, CollisionType, IncidentSeverity, AuthoritiesContacted, IncidentState, IncidentCity, IncidentLocation, IncidentHourOfTheDay, NumberOfVehiclesInvolved, PropertyDamage, BodilyInjuries, Witnesses, PoliceReportAvailable, TotalClaimAmount, InjuryClaim, PropertyClaim, VehicleClaim)
SELECT incident_date, incident_type, collision_type, incident_severity, authorities_contacted, incident_state, incident_city, incident_location, incident_hour_of_the_day, number_of_vehicles_involved, property_damage, bodily_injuries, witnesses, police_report_available, total_claim_amount, injury_claim, property_claim, vehicle_claim
FROM insurance_claims;

-- Insert Data into Vehicles Table
INSERT INTO Vehicles (AutoMake, AutoModel, AutoYear)
SELECT auto_make, auto_model, auto_year
FROM insurance_claims;
CapitalGains

-- Include the TotalClaimAmount in the Claims table
ALTER TABLE Claims ADD COLUMN TotalClaimAmount NUMERIC;
UPDATE Claims c
SET TotalClaimAmount = i.TotalClaimAmount
FROM Incidents i
WHERE c.IncidentID = i.IncidentID;

-- Insert Data into Claims Table
INSERT INTO Claims (PolicyID, InsuredID, IncidentID, VehicleID, FraudReported, AdditionalInfo)
SELECT p.PolicyID, i.InsuredID, d.IncidentID, v.VehicleID, s.fraud_reported, s._c39
FROM insurance_claims s

JOIN Policies p ON s.policy_number = p.PolicyNumber
JOIN Insured i ON s.insured_zip = i.InsuredZip AND s.insured_sex = i.InsuredSex AND s.insured_education_level = i.InsuredEducationLevel AND s.insured_occupation = i.InsuredOccupation AND s.insured_hobbies = i.InsuredHobbies AND s.insured_relationship = i.InsuredRelationship AND s.capital_gains = i.CapitalGains AND s.capital_loss = i.CapitalLoss
JOIN Incidents d ON s.incident_date = d.IncidentDate AND s.incident_type = d.IncidentType AND s.collision_type = d.CollisionType AND s.incident_severity = d.IncidentSeverity AND s.authorities_contacted = d.AuthoritiesContacted AND s.incident_state = d.IncidentState AND s.incident_city = d.IncidentCity AND s.incident_location = d.IncidentLocation AND s.incident_hour_of_the_day = d.IncidentHourOfTheDay AND s.number_of_vehicles_involved = d.NumberOfVehiclesInvolved AND s.property_damage = d.PropertyDamage AND s.bodily_injuries = d.BodilyInjuries AND s.witnesses = d.Witnesses AND s.police_report_available = d.PoliceReportAvailable AND s.total_claim_amount = d.TotalClaimAmount AND s.injury_claim = d.InjuryClaim AND s.property_claim = d.PropertyClaim AND s.vehicle_claim = d.VehicleClaim
JOIN Vehicles v ON s.auto_make = v.AutoMake AND s.auto_model = v.AutoModel AND s.auto_year = v.AutoYear;





















