package com.babacar.drone.payload.response;

import com.babacar.drone.entity.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationsResponse {
    private int medications_number;
    private LocalDateTime timestamp;
    private List<Medication> medications;
}
