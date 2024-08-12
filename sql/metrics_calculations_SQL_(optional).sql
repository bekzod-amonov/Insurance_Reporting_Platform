SELECT * FROM public.insurance_claims

-- basic metrics
SELECT 
    COUNT(*) as total_claims,
    AVG(policy_annual_premium) as avg_premium,
    SUM(total_claim_amount) as total_claims_amount,
    AVG(age) as avg_age,
    COUNT(CASE WHEN fraud_reported = 'Y' THEN 1 END) as fraud_cases
FROM insurance_claims;

-- Average Policy Premium
SELECT AVG(policy_annual_premium) as avg_premium
FROM insurance_claims;
--result: 1256.4061500000000000

--Total Claim Amount by Policy State:
SELECT policy_state, SUM(total_claim_amount) as total_claims
FROM insurance_claims
GROUP BY policy_state
ORDER BY total_claims DESC;
--result: 
--"OH"	18468450
--"IL"	17861330
--"IN"	16432160

--Claim Frequency (as a proxy for risk):
SELECT 
    COUNT(*) * 1.0 / COUNT(DISTINCT policy_number) as claim_frequency
FROM insurance_claims;
--result: 1.00000000000000000000

-- Loss Ratio (as a simplified version of PVFP)
SELECT 
    SUM(total_claim_amount) * 1.0 / SUM(policy_annual_premium) as loss_ratio
FROM insurance_claims;
--result: 41.9943343957684384

-- Value of New Business (VNB) approximation
SELECT 
    AVG(CASE 
        WHEN months_as_customer <= 12 THEN policy_annual_premium - total_claim_amount
        ELSE NULL 
    END) as estimated_vnb
FROM insurance_claims;
-- result: -50866.974000000000

--Risk-based Capital (a component of Solvency II):
SELECT 
    policy_state,
    AVG(total_claim_amount) as avg_claim,
    STDDEV(total_claim_amount) as claim_stddev,
    AVG(total_claim_amount) + (2 * STDDEV(total_claim_amount)) as risk_based_capital
FROM insurance_claims
GROUP BY policy_state;
--result:
--"IL"	52844.171597633136	26411.09179467	105666.355186973136
--"IN"	53006.967741935484	26678.21058890	106363.388919735484
--"OH"	52467.187500000000	26219.31890973	104905.825319460000

--Fraud Detection Rate (could be relevant for Solvency II operational risk):
SELECT 
    COUNT(CASE WHEN fraud_reported = 'Y' THEN 1 END) * 100.0 / COUNT(*) as fraud_rate
FROM insurance_claims;
--result: 24.7000000000000000

--Claims by Severity (relevant for Best Estimate Liabilities in Solvency II):
SELECT 
    incident_severity,
    COUNT(*) as claim_count,
    AVG(total_claim_amount) as avg_claim_amount
FROM insurance_claims
GROUP BY incident_severity
ORDER BY avg_claim_amount DESC;
--result:
--"Major Damage"	276	64067.173913043478
--"Total Loss"		280	62081.214285714286
--"Minor Damage"	354	48642.683615819209
--"Trivial Damage"	90	5301.6666666666666667


--Policy Distribution by Coverage (relevant for SCR calculations):
SELECT 
    policy_csl,
    COUNT(*) as policy_count,
    AVG(policy_annual_premium) as avg_premium,
    AVG(total_claim_amount) as avg_claim
FROM insurance_claims
GROUP BY policy_csl;
--result: 
--"100/300"		349	1246.7019197707736390	55265.702005730659
--"250/500"		351	1262.2980341880341880	51153.732193732194
--"500/1000"	300	1260.8019000000000000	51730.833333333333

--Time-based Claim Analysis (could be used in PVFP calculations)
SELECT 
    EXTRACT(YEAR FROM incident_date) as incident_year,
    EXTRACT(MONTH FROM incident_date) as incident_month,
    COUNT(*) as claim_count,
    SUM(total_claim_amount) as total_claims
FROM insurance_claims
GROUP BY incident_year, incident_month
ORDER BY incident_year, incident_month;
--result:
--2015	1	516	27760970
--2015	2	472	24326250
--2015	3	12	674720

--Complex analysis

--Risk Score Calculation:
--This query creates a simple risk score based on multiple factors.
SELECT 
    policy_number,
    age,
    insured_occupation,
    incident_severity,
    (CASE 
        WHEN age < 25 OR age > 70 THEN 20
        WHEN age BETWEEN 25 AND 35 OR age BETWEEN 60 AND 70 THEN 10
        ELSE 0
    END +
    CASE 
        WHEN incident_severity = 'Major Damage' THEN 30
        WHEN incident_severity = 'Minor Damage' THEN 15
        ELSE 0
    END +
    CASE 
        WHEN insured_occupation IN ('craft-repair', 'machine-op-inspct') THEN 15
        ELSE 0
    END) AS risk_score
FROM insurance_claims
ORDER BY risk_score DESC;

--Claim Propensity Model:
--This query creates a simple propensity model to predict claim likelihood.
WITH claim_propensity AS (
    SELECT 
        age,
        insured_occupation,
        insured_hobbies,
        incident_severity,
        COUNT(*) AS claim_count,
        AVG(total_claim_amount) AS avg_claim_amount
    FROM insurance_claims
    GROUP BY age, insured_occupation, insured_hobbies, incident_severity
)
SELECT 
    cp.*,
    NTILE(10) OVER (ORDER BY claim_count * avg_claim_amount DESC) AS risk_decile
FROM claim_propensity cp
ORDER BY risk_decile, claim_count DESC;

--Time-based Premium and Claim Analysis:
--This query analyzes how premiums and claims change over time.
WITH time_analysis AS (
    SELECT 
        DATE_TRUNC('month', policy_bind_date) AS policy_month,
        AVG(policy_annual_premium) AS avg_premium,
        COUNT(*) AS policy_count,
        SUM(CASE WHEN incident_date IS NOT NULL THEN 1 ELSE 0 END) AS claim_count,
        SUM(total_claim_amount) AS total_claims
    FROM insurance_claims
    GROUP BY DATE_TRUNC('month', policy_bind_date)
)
SELECT 
    policy_month,
    avg_premium,
    policy_count,
    claim_count,
    total_claims,
    claim_count::float / policy_count AS claim_frequency,
    total_claims / NULLIF(claim_count, 0) AS avg_claim_severity,
    total_claims / (avg_premium * policy_count) AS loss_ratio
FROM time_analysis
ORDER BY policy_month;

--Customer Segmentation:
--This query segments customers based on their characteristics and claim history.
WITH customer_segments AS (
    SELECT 
        insured_education_level,
        insured_occupation,
        age,
        COUNT(*) AS policy_count,
        AVG(policy_annual_premium) AS avg_premium,
        AVG(total_claim_amount) AS avg_claim,
        SUM(CASE WHEN fraud_reported = 'Y' THEN 1 ELSE 0 END)::float / COUNT(*) AS fraud_rate
    FROM insurance_claims
    GROUP BY insured_education_level, insured_occupation, age
)
SELECT 
    *,
    CASE 
        WHEN avg_premium > 1500 AND avg_claim < 10000 THEN 'High Value'
        WHEN avg_premium < 1000 AND avg_claim > 20000 THEN 'High Risk'
        WHEN fraud_rate > 0.1 THEN 'Fraud Prone'
        ELSE 'Standard'
    END AS customer_segment
FROM customer_segments
ORDER BY avg_premium DESC;


--Policy Renewal Prediction:
--This query attempts to predict policy renewal likelihood based on claim history and customer characteristics.
WITH renewal_factors AS (
    SELECT 
        policy_number,
        months_as_customer,
        age,
        insured_education_level,
        policy_annual_premium,
        total_claim_amount,
        CASE WHEN incident_date IS NOT NULL THEN 1 ELSE 0 END AS had_claim,
        CASE WHEN fraud_reported = 'Y' THEN 1 ELSE 0 END AS reported_fraud
    FROM insurance_claims
)
SELECT 
    *,
    CASE 
        WHEN months_as_customer > 60 AND had_claim = 0 THEN 'Very Likely'
        WHEN months_as_customer > 24 AND total_claim_amount < policy_annual_premium THEN 'Likely'
        WHEN reported_fraud = 1 THEN 'Unlikely'
        WHEN total_claim_amount > policy_annual_premium * 2 THEN 'At Risk'
        ELSE 'Neutral'
    END AS renewal_likelihood
FROM renewal_factors;

