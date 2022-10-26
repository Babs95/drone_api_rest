package com.babacar.drone.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDroneResponse {

    private String response;
    private int code;
    private String serialNumber;
    private String message;
    private LocalDateTime timestamp;
}
