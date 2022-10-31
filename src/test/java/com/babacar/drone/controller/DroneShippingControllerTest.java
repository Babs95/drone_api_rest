package com.babacar.drone.controller;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.entity.Medication;
import com.babacar.drone.enums.Model;
import com.babacar.drone.enums.State;
import com.babacar.drone.payload.request.RegisterDroneShippingRequest;
import com.babacar.drone.payload.request.RegisterMedicationRequest;
import com.babacar.drone.payload.response.DroneLoadedMedicationsResponse;
import com.babacar.drone.payload.response.RegisterDroneShippingResponse;
import com.babacar.drone.service.DroneServiceImpl;
import com.babacar.drone.service.DroneShippingServiceImpl;
import com.babacar.drone.service.MedicationServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class DroneShippingControllerTest {
    @Autowired
    private DroneShippingServiceImpl droneShippingService;
    @Autowired
    private MedicationServiceImpl medicationService;
    @Autowired
    private DroneServiceImpl droneService;

    @BeforeEach
    void setUp() {
        Drone newdrone = new Drone("XCDU9D0", Model.Heavyweight, 500.0, 85, State.LOADING);
        Drone newdrone1 = new Drone("ETDFD667", Model.Lightweight, 300.0, 85, State.LOADING);
        Drone newdrone2 = new Drone("BAB56766784A6", Model.Cruiserweight, 395.45, 85, State.LOADING);
        droneService.register(newdrone);
        droneService.register(newdrone1);
        droneService.register(newdrone2);

        RegisterMedicationRequest medicationRequest = new RegisterMedicationRequest("CO6766784","Covax",200.0,"image1.png");
        RegisterMedicationRequest medicationRequest1 = new RegisterMedicationRequest("DI-908-CG","Diprolene",100.0,"image2.png");
        RegisterMedicationRequest medicationRequest2 = new RegisterMedicationRequest("NEU-788-FD","Neutrocold",50.0,"image3.png");
        medicationService.register(medicationRequest);
        medicationService.register(medicationRequest1);
        medicationService.register(medicationRequest2);
    }

    @Test
    void canRegisterDroneShipping() throws Exception {

        // given
        ArrayList<String> medications = new ArrayList<String>();
        medications.add("DI-908-CG");
        medications.add("CO6766784");
        medications.add("NEU-788-FD");
        RegisterDroneShippingRequest droneShippingRequest = new RegisterDroneShippingRequest("Liberte VI","XCDU9D0",medications);
        // when
        RegisterDroneShippingResponse newDroneShipping = droneShippingService.registerDroneForShipping(droneShippingRequest);
        // then
       AssertionsForClassTypes.assertThat(newDroneShipping.getTotalWeight()).isEqualTo(350.0);
    }


}