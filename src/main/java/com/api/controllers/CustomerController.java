package com.api.controllers;

import com.api.dtos.CreateCustomerDTO;
import com.api.dtos.UpdateCustomerDTO;
import com.api.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping(value = "/api/v1/")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "customers")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.customerService.getAll());
    }

    @GetMapping(value = "customers/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.getCustomerById(id));
    }

    @PostMapping(value = "customers")
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return ResponseEntity.ok(this.customerService.createCustomer(createCustomerDTO));
    }

    @PutMapping(value = "customers/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        return ResponseEntity.ok(this.customerService.updateCustomer(id, updateCustomerDTO));
    }

    @DeleteMapping(value = "customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.deleteCustomer(id));
    }
}
