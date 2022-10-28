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
public class RegisterDroneShippingResponse {
    private String response;
    private int code;
    private String message;
    private String shippingAddress;
    private int quantityTotal;
    private String serialNumber;
    private List<Medication> medications;
    private LocalDateTime timestamp;
}
