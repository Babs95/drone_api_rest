package com.babacar.drone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import java.util.List;

/**
 *
 * @author Babacar
 * Entity class to map drone_shipping data in h2 database
 *
 */

@Entity
@Table(name = "drone_shipping")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="shipping_address")
    private String shippingAddress;

    @Column(name="quantity_total")
    private Integer totalQuantity;

    @Column(name="total_weight")
    private Double totalWeight;

    @Column(name="drone_serial_num")
    private String droneSerialNum;

    @Column(name="medications_loaded")
    @OneToMany
    private List<Medication> medications;

}
