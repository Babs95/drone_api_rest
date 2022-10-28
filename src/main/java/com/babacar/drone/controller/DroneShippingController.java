package com.babacar.drone.controller;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.request.RegisterDroneShippingRequest;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.payload.response.RegisterDroneShippingResponse;
import com.babacar.drone.service.DroneShippingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
