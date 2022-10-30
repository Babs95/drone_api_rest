package com.babacar.drone.repository;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Transactional
@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {
    @Modifying
    @Query(value = "update Drone d set d.state = :state where  d.serialNumber= :serial_number")
    int setDroneState (State state,String serial_number);
    List<Drone> findByState(State state);
    Drone findBySerialNumber(@Param("serial") String serial);

}
