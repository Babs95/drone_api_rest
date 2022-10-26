package com.babacar.drone.payload.response;

import com.babacar.drone.entity.Drone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDroneResponse {
    private int drones_number;
    private LocalDateTime timestamp;
    private List<Drone> drones;
}
