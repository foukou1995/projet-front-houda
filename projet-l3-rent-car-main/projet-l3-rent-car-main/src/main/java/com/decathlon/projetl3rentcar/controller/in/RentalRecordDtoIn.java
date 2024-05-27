package com.decathlon.projetl3rentcar.controller.in;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RentalRecordDtoIn {
    private int vehicleId;
    private int customerId;
    private float totalCost;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
}
