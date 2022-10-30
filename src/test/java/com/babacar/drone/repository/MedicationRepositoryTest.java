package com.babacar.drone.repository;

import com.babacar.drone.entity.Medication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MedicationRepositoryTest {

    @Autowired
    MedicationRepository medicationRepository;

    @AfterEach
    void tearDown() {
        medicationRepository.deleteAll();
    }

    @Test
    void itShouldFindMedicationByCode() {
        // given
        Medication medication = new Medication("CO6766784","Covax",200.0,"image1.png");
        Medication medication1 = new Medication("DI-908-CG","Diprolene",100.0,"image2.png");
        medicationRepository.save(medication);
        medicationRepository.save(medication1);
        // when
        Medication result = medicationRepository.findByCode(medication.getCode());
        // then
        assertThat(result).isEqualTo(medication);
    }
}