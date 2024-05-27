package com.decathlon.projetl3rentcar.controller;

import com.decathlon.projetl3rentcar.configuration.ExceptionHandlerConfiguration;
import com.decathlon.projetl3rentcar.controller.in.VehicleDtoIn;
import com.decathlon.projetl3rentcar.controller.out.VehicleDtoOut;
import com.decathlon.projetl3rentcar.service.VehicleService;
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
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@Tag(name = "Products")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(value = "/vehicles")
    @Operation(summary = "Endpoint to get list of vehicles", description = "Endpoint to get list of vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicles list found", content = {@Content(array = @ArraySchema(schema = @Schema(implementation =VehicleDtoOut.class)))}),
            @ApiResponse(responseCode = "204", description = "No components type found", content = @Content(schema = @Schema()))
    })
    public ResponseEntity<Collection<VehicleDtoOut>> getType() {

        return getCollectionResponseEntity(vehicleService.getVehicles());
    }


    @ResponseStatus(CREATED)
    @PostMapping("/vehicles")
    @Operation(summary = "Endpoint to add a new vehicle", description = "Endpoint to add a new vehicle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "vehicle added", content = {@Content(schema = @Schema(implementation = VehicleDtoOut.class))}),
            @ApiResponse(responseCode = "406", description = "Duplicate vehicles name", content = {@Content(schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))})
    })
    public VehicleDtoOut createVehicle(@RequestBody VehicleDtoIn vehicleDtoIn) {
        return vehicleService.createVehicle(vehicleDtoIn);
    }

    @DeleteMapping("/vehicles/{id}")
    @Operation(summary = "Endpoint to delete product", description = "Endpoint to update product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ExceptionHandlerConfiguration.ErrorResponse.class))}),
    })
    void deleteVehicle(
            @PathVariable(name = "id") Integer vehicleId
    ) {
        vehicleService.deleteVehicle(vehicleId);
    }
}
