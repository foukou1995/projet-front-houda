package com.decathlon.projetl3rentcar.service;

import com.decathlon.projetl3rentcar.controller.in.VehicleDtoIn;
import com.decathlon.projetl3rentcar.controller.out.VehicleDtoOut;

import com.decathlon.projetl3rentcar.entity.Vehicle;
import com.decathlon.projetl3rentcar.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Service
@RequiredArgsConstructor
@Validated
public class VehicleService {
    @Autowired
    private final VehicleRepository vehicleRepository;
    public List<VehicleDtoOut> getVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleDtoOut::new).toList();
    }

    public VehicleDtoOut createVehicle(VehicleDtoIn vehicleDtoIn) {
        Vehicle vehicle = Vehicle.builder()
                .model(vehicleDtoIn.getModel())
                .brand(vehicleDtoIn.getBrand())
                .available(vehicleDtoIn.isAvailable())
                .location(vehicleDtoIn.getLocation())
                .rental_cost_per_day(vehicleDtoIn.getRental_cost_per_day())
                .year(vehicleDtoIn.getYear())
                .build();
        vehicle = vehicleRepository.save(vehicle);
        return new VehicleDtoOut(vehicle);
    }
    public void deleteVehicle(Integer vehicleId){
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResponseStatusException(NO_CONTENT, "Vehicle for id " + vehicleId + " already deleted or never created"));
        vehicleRepository.delete(vehicle);
    }


}
