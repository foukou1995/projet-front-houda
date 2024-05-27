package com.decathlon.projetl3rentcar.controller.out;

import com.decathlon.projetl3rentcar.entity.Customer;
import com.decathlon.projetl3rentcar.entity.RentalRecord;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalRecordDtoOut {
    private int id;
    private int vehicleId;
    private int customerId;
    private float totalCost;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    public RentalRecordDtoOut(RentalRecord rentalRecord ) {
        this.id = rentalRecord.getId();
        this.vehicleId = rentalRecord.getVehicleId();
        this.customerId = rentalRecord.getCustomerId();
        this.totalCost = rentalRecord.getTotalCost();
        this.startDate=rentalRecord.getStartDate();
        this.endDate=rentalRecord.getEndDate();
    }

}
