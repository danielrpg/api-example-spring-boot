package com.api.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    @Size(max = 100)
    @NotBlank(message = "Please enter product name")
    @NotNull
    private String name;

    @Column(name = "product_price")
   // @NotBlank(message = "Please enter product price") //It is not working with Decimal values
    @NotNull
    private BigDecimal price;

    @Column(name = "product_date")
    private Date productDate;
}
