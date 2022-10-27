package com.babacar.drone.service;

import com.babacar.drone.entity.Medication;
import com.babacar.drone.payload.request.RegisterMedicationRequest;
import com.babacar.drone.payload.response.MedicationsResponse;
import com.babacar.drone.payload.response.RegisterMedicationResponse;
import com.babacar.drone.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService{

    private MedicationRepository medicationRepository;

    @Autowired
    public MedicationServiceImpl(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }

    @Override
    public RegisterMedicationResponse register(RegisterMedicationRequest registerMedicationRequest) {
        Medication medication = new Medication();
        medication.setCode(registerMedicationRequest.getCode());
        medication.setName(registerMedicationRequest.getName());
        medication.setWeight(registerMedicationRequest.getWeight());
        medication.setImage(registerMedicationRequest.getImage());
        medicationRepository.save(medication);

        RegisterMedicationResponse registerMedicationResponse = new RegisterMedicationResponse();
        registerMedicationResponse.setResponse("success");
        registerMedicationResponse.setCode(200);
        registerMedicationResponse.setMedCode(medication.getCode());
        registerMedicationResponse.setMessage("Medication created successfully!");
        registerMedicationResponse.setTimestamp(java.time.LocalDateTime.now());

        return registerMedicationResponse;
    }

    @Override
    public MedicationsResponse getAllMedications() {
        List<Medication> medications = medicationRepository.findAll();
        return new MedicationsResponse(medications.size(), java.time.LocalDateTime.now(), medications);
    }
}
