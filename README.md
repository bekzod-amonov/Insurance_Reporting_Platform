# Insurance Claims Data Analytics and Reporting Platform

## Overview

This project is a comprehensive data analytics and reporting platform for insurance data. It handles data ingestion, transformation, and generates insightful reports on key performance indicators (KPIs) such as PVFP, VNB, and other Solvency II metrics. Please see the reference part below to get an overview of the dataset used.

## Project Structure

- **SQL**: Contains scripts for creating tables and inserting data.
  - `sql/create_tables_SQL.sql`
  - `sql/metrics_calculations_SQL_(optional).sql`
  - `sql/insurance_claims_dataset.sql`
- **R**: Contains the R script for KPI calculations.
  - `r/kpi_calculations_R.R`
- **Java** (insurance_claims folder): Contains the Spring Boot application with controllers, models, repositories, and services.
  - `src/main/java/com/example/insurance_claims/`
  - `src/test/java/com/example/insurance_claims/`
  - `src/main/resources/application.properties`
- **Configuration**: Maven build file and application properties.
  - `pom.xml`
  - `src/main/resources/application.properties`

## Setup Instructions

### Prerequisites

- PostgreSQL
- R and RStudio
- Java 17
- Maven

### Step-by-Step Setup

1. **Clone the repository**:
2. **SQL Setup**:
   - Run the scripts in the sql directory to set up the database.
   - Ensure PostgreSQL is running and accessible.
3. **R Setup**: 
   - Open r/kpi_calculations.R in RStudio.
   - Install required packages and run the script to perform KPI calculations.
   - Save the results back to the database.
4. **Java Setup**:
   - Ensure Maven is installed.
   - Update the application.properties file with your PostgreSQL credentials.
   - Build and run the application:
       `mvn clean install`
       `mvn spring-boot:run`
5. **Access the Application**:
   - Open your browser and go to `http://localhost:8081`. 
   - `mvn spring-boot:run`

    Run unit and integration tests using Maven:
        `mvn test`

6. **Usage**:
    Access the endpoints to interact with the application.
      - List all vehicles: `http://localhost:8081/api/vehicles`
      - List all KPIs: `http://localhost:8081/api/kpis`
      - Get vehicle by ID: `http://localhost:8081/api/vehicles/{id}` (note: the link is under construction)
      - Get KPI by policy ID: `http://localhost:8081/api/kpis/{policyId}` (note: the link is under construction)

7. **Reference**:
     - Dataset: AQQAD, ABDELRAHIM (2023), “insurance_claims ”, Mendeley Data, V2, doi: 10.17632/992mh7dk9y.2
  
 **License**
      This project is licensed under the MIT License.
