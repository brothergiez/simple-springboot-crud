package com.restapi.fpttestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.fpttestapi.model.Customer;

public interface CustomersRepository extends JpaRepository<Customer, Integer>{

}
