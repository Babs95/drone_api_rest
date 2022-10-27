package com.babacar.drone.controller;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.request.RegisterMedicationRequest;
import com.babacar.drone.payload.response.AvailableDroneResponse;
import com.babacar.drone.payload.response.MedicationsResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.payload.response.RegisterMedicationResponse;
import com.babacar.drone.service.MedicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path="/api/medication/v1")
@Validated
public class MedicationController {

    private MedicationServiceImpl medicationService;

    @Autowired
    public MedicationController(MedicationServiceImpl medicationService){
        this.medicationService = medicationService;
    }

    @PostMapping(path="/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RegisterMedicationResponse> registerDrone(
            @Valid @RequestBody RegisterMedicationRequest medicationRequest, Errors errors) {
        RegisterMedicationResponse newMedication = medicationService.register(medicationRequest);
        return new ResponseEntity<RegisterMedicationResponse>(newMedication, HttpStatus.CREATED);
    }

    @GetMapping(path= "/medications", produces = "application/json")
    public ResponseEntity<MedicationsResponse> getAllMedications() {
        MedicationsResponse medications = medicationService.getAllMedications();
        return new ResponseEntity<MedicationsResponse>(medications, HttpStatus.OK);
    }
}
