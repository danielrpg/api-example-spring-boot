package com.api.controllers;

import com.api.dtos.CreateCustomerDTO;
import com.api.dtos.UpdateCustomerDTO;
import com.api.models.Customer;
import com.api.payload.MessageResponse;
import com.api.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/api/customers")
    public List<Customer> getAll() {
        return this.customerService.getAll();
    }

    @PostMapping(value = "/api/customers")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return ResponseEntity.ok(this.customerService.createCustomer(createCustomerDTO));
    }

    @PutMapping(value = "/api/customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return ResponseEntity.ok(this.customerService.updateCustomer(id, updateCustomerDTO));
    }

    @DeleteMapping(value = "/api/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.deleteCustomer(id));
    }
}
