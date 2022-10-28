package com.babacar.drone.repository;

import com.babacar.drone.entity.DroneShipping;
import com.babacar.drone.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneShippingRepository extends JpaRepository<DroneShipping,Long> {
}