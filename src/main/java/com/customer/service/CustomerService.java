package com.customer.service;

import com.customer.model.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {

    public Flux<Customer> getAllEmployee();
    public Mono<Customer> getEmployeeById(Integer Id);
    public Mono<Customer> createEmployee(Customer cust);
    public Mono<Customer> updateEmployeeById( Customer customer,Integer id);
    public Mono<Void> deleteEmployee(Integer id);
}
