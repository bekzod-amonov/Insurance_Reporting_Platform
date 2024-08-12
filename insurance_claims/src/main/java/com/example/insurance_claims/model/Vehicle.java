package com.example.insurance_claims.model;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleid")
    private Long vehicleId;

    @Column(name = "automake")
    private String autoMake;

    @Column(name = "automodel")
    private String autoModel;

    @Column(name = "autoyear")
    private Integer autoYear;

    // No-args constructor
    public Vehicle() {}

    // Getters and Setters
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", autoMake='" + autoMake + '\'' +
                ", autoModel='" + autoModel + '\'' +
                ", autoYear=" + autoYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId);
    }
}

