package com.api.services;

import com.api.dtos.CreateCustomerDTO;
import com.api.dtos.CustomerDTO;
import com.api.dtos.UpdateCustomerDTO;
import com.api.models.Customer;
import com.api.payload.MessageResponse;
import com.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public static final String CUSTOMER_CREATED_SUCCESSFULLY = "Customer created successfully";
    public static final String CUSTOMER_UPDATED_SUCCESSFULLY = "Customer updated successfully";
    public static final String CUSTOMER_DELETED_SUCCESSFULLY = "Customer deleted successfully";

    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Transactional
    public MessageResponse createCustomer(CustomerDTO createCustomerDTO) {
        Customer newCustomer = getCustomer(createCustomerDTO, new Customer());
        customerRepository.save(newCustomer);
        return getResponseMessage(newCustomer, CUSTOMER_CREATED_SUCCESSFULLY);
    }

    @Transactional
    public MessageResponse updateCustomer(Long id, CustomerDTO updateCustomerDTO) {
        Customer customer = this.customerRepository.findById(id).get();
        Customer updatedCustomer = getCustomer(updateCustomerDTO, customer);
        customerRepository.save(updatedCustomer);
        return getResponseMessage(updatedCustomer, CUSTOMER_UPDATED_SUCCESSFULLY);
    }

    public MessageResponse deleteCustomer(Long id) {
        Customer deletedCustomer = this.customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return getResponseMessage(deletedCustomer, CUSTOMER_DELETED_SUCCESSFULLY);
    }

    private MessageResponse getResponseMessage(Customer updatedCustomer, String message) {
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setStatus(true);
        messageResponse.setErrorCode(200);
        messageResponse.setMessage(message);
        List<Customer> listUpdatedCustomers = new ArrayList<>();
        listUpdatedCustomers.add(updatedCustomer);
        messageResponse.setCustomer(listUpdatedCustomers);
        return messageResponse;
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
