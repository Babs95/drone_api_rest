package com.babacar.drone.entity;

import com.babacar.drone.enums.Model;
import com.babacar.drone.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

/**
 *
 * @author Babacar
 * Entity class to map drone data in h2 database
 *
 */

@Entity
@Table(name = "drone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id
    @Column(name="serial_number",length = 100)
    private String serialNumber;

    @Column(name="model")
    @Enumerated(value = EnumType.STRING)
    private Model model;

    @Column(name="weight_limit")
    @DecimalMax(value = "500", message =" Drone cannot be loaded because it's cannot carry more than {value} grams")
    private Double  weightLimit;

    @Column(name="battery_life")
    @Max(value=100,message="Drone Battery life cannot be more than 100%")
    private Integer battery;

    @Column(name = "state")
    @Enumerated(value = EnumType.STRING)
    private State state;
}
