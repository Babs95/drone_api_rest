package com.babacar.drone.repository;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DroneRepository extends JpaRepository<Drone, String> {
    @Modifying
    @Query(value = "update Drone d set d.state = :state where  d.serialNumber= :serial_number")
    void setDroneState (State state,String serial_number);
    List<Drone> findByState(State state);
    Drone findBySerialNumber(@Param("serial") String serial);

}
