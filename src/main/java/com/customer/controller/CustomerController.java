package com.customer.controller;

import com.customer.model.Customer;

import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public Flux<ResponseEntity<Customer>> getAllCustomer(){
        return customerService.getAllEmployee().map(m -> new ResponseEntity<>(m , HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> getCustomerById(@PathVariable Integer custId){
        return customerService.getEmployeeById(custId).map(m-> new ResponseEntity<>(m, HttpStatus.OK));
    }

    @PostMapping
    public Mono<ResponseEntity<Customer>> createCustomer(@RequestBody Customer customer){
    return customerService.createEmployee(customer).map(m-> new ResponseEntity<>(m , HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> updateCustomerById(@RequestBody Customer customer, @PathVariable Integer id){
        return customerService.updateEmployeeById(customer,id).map(m -> new ResponseEntity<>(m , HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable Integer id){
        return customerService.deleteEmployee(id);
    }
}
