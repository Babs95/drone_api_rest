package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.response.AvailableDroneResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DroneService {
    RegisterDroneResponse register(Drone drone);
    AvailableDroneResponse getAllDrones();
    AvailableDroneResponse getAvailableDronesForShipping();

}
