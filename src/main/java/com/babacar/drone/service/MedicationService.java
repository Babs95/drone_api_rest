package com.babacar.drone.service;

import com.babacar.drone.entity.Drone;
import com.babacar.drone.payload.request.RegisterMedicationRequest;
import com.babacar.drone.payload.response.MedicationsResponse;
import com.babacar.drone.payload.response.RegisterDroneResponse;
import com.babacar.drone.payload.response.RegisterMedicationResponse;

public interface MedicationService {
    RegisterMedicationResponse register(RegisterMedicationRequest registerMedicationRequest);
    MedicationsResponse getAllMedications();
}
