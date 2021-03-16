package com.api.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDTO {
    protected String name;
    protected BigDecimal price;
    protected Date productDate;
}
