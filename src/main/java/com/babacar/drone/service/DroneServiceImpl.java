package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.enums.State;
import com.babacar.drone.payload.response.AvailableDroneResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService{

    private int BATTERY_LIMIT=25;
    private DroneRepository droneRepository;
    @Autowired
    public DroneServiceImpl(DroneRepository droneRepository){
        this.droneRepository = droneRepository;
    }

    @Override
    public RegisterDroneResponse register(Drone drone) {
        //Setting Default State
        if(drone.getBattery()>BATTERY_LIMIT) {
            drone.setState(State.LOADING);
        }
        else {
            drone.setState(State.IDLE);
        }

        droneRepository.save(drone);

        RegisterDroneResponse droneResponse = new RegisterDroneResponse();
        droneResponse.setResponse("success");
        droneResponse.setCode(200);
        droneResponse.setSerialNumber(drone.getSerialNumber());
        droneResponse.setMessage("Drone created successfully!");
        droneResponse.setTimestamp(java.time.LocalDateTime.now());

        return droneResponse;
    }

    @Override
    public AvailableDroneResponse getAllDrones() {
        List<Drone> drones = droneRepository.findAll();
        return new AvailableDroneResponse(drones.size(), java.time.LocalDateTime.now(), drones);
    }

    @Override
    public AvailableDroneResponse getAvailableDronesForShipping() {
        List<Drone> drones = droneRepository.findDronesByState(String.valueOf(State.IDLE));
        return null;
    }
}
