package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.enums.Model;
import com.babacar.drone.enums.State;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.repository.DroneRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DroneServiceImplTest {


    private DroneServiceImpl droneService;
    @Mock
    private DroneRepository droneRepository;

    @BeforeEach
    void setUp() {
        //To get a fresh droneService before each tests
        droneService = new DroneServiceImpl(droneRepository);
    }

    @Test
    void canRegisterNewDrone() {
        // given
        Drone drone = new Drone(
                "BAB56766784A6",
                Model.Heavyweight,
                495.1,
                50,
                State.LOADING
        );
        // when
        RegisterDroneResponse result = droneService.register(drone);
        // then
        ArgumentCaptor<Drone> droneArgumentCaptor =
                ArgumentCaptor.forClass(Drone.class);

        verify(droneRepository)
                .save(droneArgumentCaptor.capture());

        Drone capturedDrone = droneArgumentCaptor.getValue();

        assertThat(capturedDrone).isEqualTo(drone);
        assertThat(result.getCode()).isEqualTo(201);
    }

    @Test
    void canGetAllDrones() {
        //when
        droneService.getAllDrones();
        // then
        verify(droneRepository).findAll();
    }

    @Test
    @Disabled
    void getAvailableDronesForShipping() {
    }

    @Test
    @Disabled
    void getDroneBatteryLevel() {
    }
}