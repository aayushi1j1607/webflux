package com.customer.controller;

import com.customer.repository.CustomerRepository;
import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @GetMapping
    public Flux<Customer> getAllCustomer(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable Integer custId){
        return repo.findById(custId);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
return repo.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable Integer id){
        return repo.findById(id)
                .map((c)->{
                    c.setName(customer.getName());
                    return c;
        }).flatMap(s->repo.save(customer));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployee(@PathVariable Integer id){
    return repo.deleteById(id);
    }
}
