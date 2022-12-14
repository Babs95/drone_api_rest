package com.babacar.drone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Babacar
 * Entity class to map medication data in h2 database
 *
 */

@Entity
@Table(name = "medication")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

    @Id
    @Column(name="code")
    private String code;

    @Column(name = "name")
    @NotNull()
    private String name;

    @Column(name ="weight")
    private Double weight;

    @Column(name ="picture_url")
    private String image;
}
