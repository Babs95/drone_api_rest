package com.babacar.drone.controller;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.response.AvailableDroneResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.service.DroneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path="/api/drone/v1")
@Validated
public class DroneController {
    private DroneServiceImpl droneService;
    @Autowired
    public DroneController(DroneServiceImpl droneService){
        this.droneService = droneService;
    }

    @PostMapping(path="/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RegisterDroneResponse> registerDrone(
            @Valid @RequestBody Drone dronerequest) {
        RegisterDroneResponse newDrone = droneService.register(dronerequest);
        return new ResponseEntity<RegisterDroneResponse>(newDrone, HttpStatus.CREATED);
    }

    @GetMapping(path= "/drones", produces = "application/json")
    public ResponseEntity<AvailableDroneResponse> getAllDrones() {
        AvailableDroneResponse drones = droneService.getAllDrones();
        return new ResponseEntity<AvailableDroneResponse>(drones, HttpStatus.OK);
    }
}
