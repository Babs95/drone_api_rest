package com.babacar.drone.controller;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.request.RegisterDroneShippingRequest;
import com.babacar.drone.payload.response.DroneBatteryCheckResponse;
import com.babacar.drone.payload.response.DroneLoadedMedicationsResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.payload.response.RegisterDroneShippingResponse;
import com.babacar.drone.service.DroneShippingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api/drone_shipping/v1")
@Validated
public class DroneShippingController {

    private DroneShippingServiceImpl droneShippingService;

    @Autowired
    public DroneShippingController(DroneShippingServiceImpl droneShippingService){
        this.droneShippingService = droneShippingService;
    }

    @PostMapping(path="/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RegisterDroneShippingResponse> registerDroneShipping(
            @Valid @RequestBody RegisterDroneShippingRequest droneShippingRequest) {
        RegisterDroneShippingResponse newDroneShipping = droneShippingService.registerDroneForShipping(droneShippingRequest);
        return new ResponseEntity<>(newDroneShipping, HttpStatus.CREATED);
    }

    @GetMapping(path= "/checkLoaded/{serial}", produces = "application/json")
    public ResponseEntity<DroneLoadedMedicationsResponse> checkDroneLoaded(@PathVariable String serial) {
        DroneLoadedMedicationsResponse droneLoadedMedicationsResponse = droneShippingService.getDroneLoadedMedications(serial);
        return new ResponseEntity<>(droneLoadedMedicationsResponse, HttpStatus.OK);
    }
}
