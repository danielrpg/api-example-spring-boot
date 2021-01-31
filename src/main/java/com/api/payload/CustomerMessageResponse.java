package com.api.payload;

import com.api.models.Customer;

import java.util.List;

public class CustomerMessageResponse extends MessageResponse{

    private List<Customer> customer;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
