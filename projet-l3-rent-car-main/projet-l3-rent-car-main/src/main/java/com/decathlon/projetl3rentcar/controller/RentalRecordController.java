package com.decathlon.projetl3rentcar.controller;

import com.decathlon.projetl3rentcar.configuration.ExceptionHandlerConfiguration;
import com.decathlon.projetl3rentcar.controller.in.CustomerDtoIn;
import com.decathlon.projetl3rentcar.controller.in.RentalRecordDtoIn;
import com.decathlon.projetl3rentcar.controller.out.CustomerDtoOut;
import com.decathlon.projetl3rentcar.controller.out.RentalRecordDtoOut;
import com.decathlon.projetl3rentcar.service.CustomerService;
import com.decathlon.projetl3rentcar.service.RentalRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.decathlon.projetl3rentcar.configuration.ControllerConfiguration.getCollectionResponseEntity;
import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@Tag(name = "RentalRecord")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RentalRecordController {

    private final RentalRecordService rentalRecordService;

    @GetMapping(value = "/rentalRecord")
    @Operation(summary = "Endpoint to get list of rentalRecord", description = "Endpoint to get list of rentalRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "RentalRecord list found", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = RentalRecordDtoOut.class)))}),
            @ApiResponse(responseCode = "204", description = "rentalRecord type found", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<Collection<RentalRecordDtoOut>> getRentalRecord() {

        return getCollectionResponseEntity(rentalRecordService.getRecords());
    }


    @ResponseStatus(CREATED)
    @PostMapping("/rentalRecord")
    @Operation(summary = "Endpoint to add a new rentalRecord", description = "Endpoint to add a new rentalRecord")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "rentalRecord added", content = {@Content(schema = @Schema(implementation = RentalRecordDtoOut.class))}),
            @ApiResponse(responseCode = "406", description = "Duplicate vehicles name", content = {@Content(schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))})
    })
    public RentalRecordDtoOut createVehicle(@RequestBody RentalRecordDtoIn rentalRecordDtoIn) {
        return rentalRecordService.createRecord(rentalRecordDtoIn);
    }

//    @DeleteMapping("/vehicles/{id}")
//    @Operation(summary = "Endpoint to delete product", description = "Endpoint to update product")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Product deleted"),
//            @ApiResponse(responseCode = "404", description = "Product not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))}),
//    })
//    void deleteVehicle(
//            @PathVariable(name = "id") Integer vehicleId
//    ) {
//        vehicleService.deleteVehicle(vehicleId);
//    }
}
