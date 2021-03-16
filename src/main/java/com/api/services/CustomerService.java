package com.api.services;

import com.api.dtos.CustomerDTO;
import com.api.payload.CustomerMessageResponse;

public interface CustomerService {
    CustomerMessageResponse getAll();
    CustomerMessageResponse getCustomerById(Long id);
    CustomerMessageResponse createCustomer(CustomerDTO createCustomerDTO);
    CustomerMessageResponse updateCustomer(Long id, CustomerDTO updateCustomerDTO);
    CustomerMessageResponse deleteCustomer(Long id);
}
