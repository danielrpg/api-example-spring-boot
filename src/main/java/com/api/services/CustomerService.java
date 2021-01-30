package com.api.services;

import com.api.dtos.CustomerDTO;
import com.api.models.Customer;
import com.api.payload.CustomerMessageResponse;
import com.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public static final String CUSTOMER_CREATED_SUCCESSFULLY = "Customer created successfully";
    public static final String CUSTOMER_UPDATED_SUCCESSFULLY = "Customer updated successfully";
    public static final String CUSTOMER_DELETED_SUCCESSFULLY = "Customer deleted successfully";
    public static final String ALL_CUSTOMERS_LISTED = "All customers listed";

    final CustomerRepository customerRepository;  // Definicion del clase a ser injectada

    /**
     * Injectando clase via constructor CustomerRepository
     * @param CustomerRepository
     **/
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository; // asignando dependencia
    }

    public CustomerMessageResponse getAll() {
        List<Customer> customerList = this.customerRepository.findAll();
        return getResponseMessage(customerList, ALL_CUSTOMERS_LISTED);
    }

    @Transactional
    public CustomerMessageResponse createCustomer(CustomerDTO createCustomerDTO) {
        Customer newCustomer = getCustomer(createCustomerDTO, new Customer());
        customerRepository.save(newCustomer);
        return getResponseMessage(newCustomer, CUSTOMER_CREATED_SUCCESSFULLY);
    }

    @Transactional
    public CustomerMessageResponse updateCustomer(Long id, CustomerDTO updateCustomerDTO) {
        Customer customer = this.customerRepository.findById(id).get();
        Customer updatedCustomer = getCustomer(updateCustomerDTO, customer);
        customerRepository.save(updatedCustomer);
        return getResponseMessage(updatedCustomer, CUSTOMER_UPDATED_SUCCESSFULLY);
    }

    @Transactional
    public CustomerMessageResponse deleteCustomer(Long id) {
        Customer deletedCustomer = this.customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return getResponseMessage(deletedCustomer, CUSTOMER_DELETED_SUCCESSFULLY);
    }

    private CustomerMessageResponse getResponseMessage(Customer updatedCustomer, String message) {
        CustomerMessageResponse customerMessageResponse = new CustomerMessageResponse();
        customerMessageResponse.setStatus(true);
        customerMessageResponse.setErrorCode(200);
        customerMessageResponse.setMessage(message);
        List<Customer> listUpdatedCustomers = new ArrayList<>();
        listUpdatedCustomers.add(updatedCustomer);
        customerMessageResponse.setCustomer(listUpdatedCustomers);
        return customerMessageResponse;
    }

    private CustomerMessageResponse getResponseMessage(List<Customer> customerList, String message) {
        CustomerMessageResponse customerMessageResponse = new CustomerMessageResponse();
        customerMessageResponse.setStatus(true);
        customerMessageResponse.setErrorCode(200);
        customerMessageResponse.setMessage(message);
        customerMessageResponse.setCustomer(customerList);
        return customerMessageResponse;
    }

    private Customer getCustomer(CustomerDTO customerDTO, Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setCellphone(customerDTO.getCellPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setZipCode(customerDTO.getZipCode());
        customer.setLastName(customerDTO.getLastName());
        return customer;
    }
}
