package com.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
