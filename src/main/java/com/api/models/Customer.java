package com.api.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "customers")
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    @Size(max = 100)
    @NotBlank(message = "Please enter your name")
    @NotNull
    private String name;

    @Size(max = 100)
    @NotBlank(message = "Please enter your last name")
    @NotNull
    private String lastName;

    @Size(max = 80)
    private String cellphone;

    private String address;

    @Size(max = 5)
    @NotBlank(message = "Please enter your zip code")
    @NotNull
    private String zipCode;

    public Customer(Long id, @Size(max = 100) @NotBlank(message = "Please enter your name") @NotNull String name, @Size(max = 100) @NotBlank(message = "Please enter your last name") @NotNull String lastName, @Size(max = 80) String cellphone, String address, @Size(max = 5) @NotBlank(message = "Please enter your zip code") @NotNull String zipCode) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.address = address;
        this.zipCode = zipCode;
    }

    public Customer() {
    }
}
