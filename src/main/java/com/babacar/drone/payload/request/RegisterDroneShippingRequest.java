package com.babacar.drone.payload.request;

import com.babacar.drone.entity.Medication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDroneShippingRequest {
    @NotEmpty
    @NotBlank
    private String shippingAddress;

    @NotEmpty
    @NotBlank
    private String droneSerialNum;

    @NotEmpty(message = "Input medication code list cannot be empty.")
    private List<String> medications_code;
}
