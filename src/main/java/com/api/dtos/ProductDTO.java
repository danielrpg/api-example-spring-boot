package com.api.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {
    protected String name;
    protected BigDecimal price;
    protected Date productDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }
}
