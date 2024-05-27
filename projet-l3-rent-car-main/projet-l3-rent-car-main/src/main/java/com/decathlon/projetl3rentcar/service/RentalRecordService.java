package com.decathlon.projetl3rentcar.service;

import com.decathlon.projetl3rentcar.controller.in.CustomerDtoIn;
import com.decathlon.projetl3rentcar.controller.in.RentalRecordDtoIn;
import com.decathlon.projetl3rentcar.controller.out.CustomerDtoOut;
import com.decathlon.projetl3rentcar.controller.out.RentalRecordDtoOut;
import com.decathlon.projetl3rentcar.entity.Customer;
import com.decathlon.projetl3rentcar.entity.RentalRecord;
import com.decathlon.projetl3rentcar.repository.CustomerRepository;
import com.decathlon.projetl3rentcar.repository.RentalRecordRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class RentalRecordService {
    @Autowired
    private final RentalRecordRepository rentalRecordRepository;
    public List<RentalRecordDtoOut> getRecords() {
        return rentalRecordRepository.findAll()
                .stream()
                .map(RentalRecordDtoOut::new).toList();
    }

    public RentalRecordDtoOut createRecord(@Valid RentalRecordDtoIn rentalRecordDtoIn) {
        //validateComponent(componentDtoIn);
        RentalRecord rentalRecord = RentalRecord.builder()
                .endDate(rentalRecordDtoIn.getEndDate())
                .startDate(rentalRecordDtoIn.getStartDate())
                .vehicleId(rentalRecordDtoIn.getVehicleId())
                .customerId(rentalRecordDtoIn.getCustomerId())
                .totalCost(rentalRecordDtoIn.getTotalCost())
                .build();
        rentalRecord = rentalRecordRepository.save(rentalRecord);
        return new RentalRecordDtoOut(rentalRecord);
    }

//    public void deleteVehicle(Integer vehicleId){
//        Vehicle vehicle = vehicleRepository.findById(vehicleId)
//                .orElseThrow(() -> new ResponseStatusException(NO_CONTENT, "Vehicle for id " + vehicleId + " already deleted or never created"));
//        vehicleRepository.delete(vehicle);
//    }


}
