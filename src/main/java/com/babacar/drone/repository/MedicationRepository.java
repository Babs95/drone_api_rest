package com.babacar.drone.repository;

import com.babacar.drone.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {
    Medication findByCode(String code);
}
