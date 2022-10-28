package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.entity.DroneShipping;
import com.babacar.drone.entity.Medication;
import com.babacar.drone.enums.State;
import com.babacar.drone.payload.request.RegisterDroneShippingRequest;
import com.babacar.drone.payload.response.AvailableDroneResponse;
import com.babacar.drone.payload.response.ErrorResponse;
import com.babacar.drone.payload.response.RegisterDroneShippingResponse;
import com.babacar.drone.repository.DroneRepository;
import com.babacar.drone.repository.DroneShippingRepository;
import com.babacar.drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DroneShippingServiceImpl implements DroneShippingService{
    private DroneRepository droneRepository;
    private DroneShippingRepository droneShippingRepository;
    private MedicationRepository medicationRepository;
    @Autowired
    public DroneShippingServiceImpl(DroneRepository droneRepository,
                                    DroneShippingRepository droneShippingRepository,
                                    MedicationRepository medicationRepository){
        this.droneRepository = droneRepository;
        this.droneShippingRepository = droneShippingRepository;
        this.medicationRepository = medicationRepository;
    }
    @Override
    public RegisterDroneShippingResponse registerDroneForShipping(RegisterDroneShippingRequest droneShippingRequest) {
        Double totalWeight = 0.0;
        //Check if the drone exist
        Drone drone = droneRepository.findBySerialNumber(droneShippingRequest.getDroneSerialNum());

        if(drone == null)
            return new RegisterDroneShippingResponse("Error", 404, "Drone serialNumber does not exist, try another","",0,0.0,"",new ArrayList(),java.time.LocalDateTime.now());
            //throw new RuntimeException("Drone serialNumber does not exist, try another one");

        //Check if Drone can be loaded
        if(drone.getState() != State.LOADING)
            return new RegisterDroneShippingResponse("Error", 404, "This drone is not available, try another one","",0,0.0,"",new ArrayList(),java.time.LocalDateTime.now());

        //Get List of medications
        List<Medication> medications = new ArrayList<>();
        for (String code : droneShippingRequest.getMedications_code()) {
            //System.out.println("My code:" + code);
            Medication medication = medicationRepository.findByCode(code);
            if(medication == null)
                return new RegisterDroneShippingResponse("Error", 404, "This medication code: " + code + " does not exist, try another","",0,0.0,"",new ArrayList(),java.time.LocalDateTime.now());
            totalWeight += medication.getWeight();
            medications.add(medication);
        }
        if(totalWeight > drone.getWeightLimit())
            return new RegisterDroneShippingResponse("Error", 404, "This drone can't be loaded because you exceed is weight limit "+drone.getWeightLimit()+", Your actual weight is: "+ totalWeight,"",0,totalWeight,"",new ArrayList(),java.time.LocalDateTime.now());

        DroneShipping droneShipping = new DroneShipping();
        droneShipping.setShippingAddress(droneShippingRequest.getShippingAddress());
        droneShipping.setDroneSerialNum(drone.getSerialNumber());
        droneShipping.setTotalQuantity(medications.size());
        droneShipping.setTotalWeight(totalWeight);
        droneShipping.setMedications(medications);
        droneShippingRepository.save(droneShipping);

        RegisterDroneShippingResponse droneShippingResponse = new RegisterDroneShippingResponse();
        droneShippingResponse.setResponse("success");
        droneShippingResponse.setCode(201);
        droneShippingResponse.setSerialNumber(droneShipping.getDroneSerialNum());
        droneShippingResponse.setMessage("Drone loaded successfully!");
        droneShippingResponse.setShippingAddress(droneShipping.getShippingAddress());
        droneShippingResponse.setQuantityTotal(droneShipping.getTotalQuantity());
        droneShippingResponse.setTotalWeight(droneShipping.getTotalWeight());
        droneShippingResponse.setMedications(droneShipping.getMedications());
        droneShippingResponse.setTimestamp(java.time.LocalDateTime.now());

        //Update Drone State
        droneRepository.setDroneState(State.LOADED, drone.getSerialNumber());

        return droneShippingResponse;
    }
}
