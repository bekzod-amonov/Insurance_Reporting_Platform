# Insurance Claims Data Analytics and Reporting Platform

## Overview

This project is a comprehensive data analytics and reporting platform for insurance data. It handles data ingestion, transformation, and generates insightful reports on key performance indicators (KPIs) such as PVFP, VNB, and other Solvency II metrics.

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
