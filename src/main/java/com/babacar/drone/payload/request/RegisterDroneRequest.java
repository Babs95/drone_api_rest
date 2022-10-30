package com.babacar.drone.payload.request;

import com.babacar.drone.enums.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDroneRequest {
    @NotEmpty
    @NotBlank
    private String serialNumber;
    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private Model model;
    @NotEmpty
    @DecimalMax(value = "500", message =" Drone cannot be loaded because it's cannot carry more than {value} grams")
    private Double  weightLimit;
    @NotEmpty
    @Max(value=100,message="Drone Battery life cannot be more than 100%")
    private Integer battery;
}
