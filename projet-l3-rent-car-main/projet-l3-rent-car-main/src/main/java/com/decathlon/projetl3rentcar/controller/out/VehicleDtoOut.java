package com.decathlon.projetl3rentcar.controller.out;

import com.decathlon.projetl3rentcar.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDtoOut {
    private int id;
    private String brand;
    private String model;
    private int year;
    private float rental_cost_per_day;
    private boolean available;
    private String location;

    public VehicleDtoOut(Vehicle vehicle ) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.rental_cost_per_day = vehicle.getRental_cost_per_day();
        this.available = vehicle.isAvailable();
        this.location = vehicle.getLocation();
    }

}
