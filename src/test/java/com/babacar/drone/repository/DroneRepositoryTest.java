package com.babacar.drone.repository;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.enums.Model;
import com.babacar.drone.enums.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DroneRepositoryTest {

    @Autowired
    private DroneRepository droneRepository;

    @AfterEach
    void tearDown() {
        droneRepository.deleteAll();
    }

    @Test
    void itShouldSetDroneState() {
        // given
        Drone drone = new Drone(
                "BAB56766784A6",
                Model.Heavyweight,
                495.1,
                50,
                State.LOADING
        );
        droneRepository.save(drone);
        // when
        int result = droneRepository.setDroneState(State.LOADED, drone.getSerialNumber());
        // then
        assertThat(result).isEqualTo(1);

    }

    @Test
    void itShouldFindDronesByState() {
        // given
        Drone drone = new Drone(
                "TYGD76997GV",
                Model.Lightweight,
                230.0,
                65,
                State.LOADING
        );
        droneRepository.save(drone);
        // when
        List<Drone> results = droneRepository.findByState(State.LOADING);
        // then
        Assertions.assertThat(results).isNotEmpty();
    }

    @Test
    void itShouldFindDroneBySerialNumber() {
        // given
        Drone drone = new Drone(
                "XCDU9D0",
                Model.Cruiserweight,
                320.0,
                25,
                State.IDLE
        );
        droneRepository.save(drone);
        // when
        Drone result = droneRepository.findBySerialNumber(drone.getSerialNumber());
        // then
        Assertions.assertThat(result).isEqualTo(drone);
    }
}