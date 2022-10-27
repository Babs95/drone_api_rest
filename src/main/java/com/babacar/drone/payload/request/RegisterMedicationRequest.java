package com.babacar.drone.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMedicationRequest {

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9.\\-\\/_ ]*$",
            message = "allowed only upper case letters, underscore and numbers")
    private String code;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$",
            message = "allowed only letters, numbers, ‘-‘, ‘_’")
    private String name;

    private Double weight;

    private String image;
}
