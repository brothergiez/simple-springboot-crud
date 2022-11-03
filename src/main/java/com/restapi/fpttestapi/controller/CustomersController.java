package com.restapi.fpttestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.fpttestapi.exception.ResourceNotFoundException;
import com.restapi.fpttestapi.model.Customer;
import com.restapi.fpttestapi.repository.CustomersRepository;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;
    
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customersRepository.save(customer);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        final Customer customer = customersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: "+ id));
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
        final Customer updateCustomer = customersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: "+ id));

        updateCustomer.setCustName(customerDetails.getCustName()); 
        updateCustomer.setCustAddress(customerDetails.getCustAddress()); 

        customersRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer id) {
        final Customer customer = customersRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: "+ id));

        customersRepository.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
