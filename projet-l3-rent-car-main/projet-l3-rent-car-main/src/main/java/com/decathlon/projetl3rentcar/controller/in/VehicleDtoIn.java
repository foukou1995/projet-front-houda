package com.decathlon.projetl3rentcar.controller.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDtoIn {

    private int id;
    private String brand;
    private String model;
    private int year;
    private float rental_cost_per_day;
    private boolean available;
    private String location;

}
