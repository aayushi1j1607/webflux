package com.customer.service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements  CustomerService{
@Autowired
    CustomerRepository customerRepository;

    @Override
    public Flux<Customer> getAllEmployee() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> getEmployeeById(Integer Id) {
        return customerRepository.findById(Id);
    }

    @Override
    public Mono<Customer> createEmployee(Customer cust) {
        return customerRepository.save(cust);
    }

    @Override
    public Mono<Customer> updateEmployeeById( Customer customer, Integer id) {
        return customerRepository.findById(id).map((c)->{
            c.setName(customer.getName());
            c.setSalary(customer.getSalary());
            return c;
        }).flatMap(s->customerRepository.save(customer));

    }

    @Override
    public Mono<Void> deleteEmployee(Integer id) {
        return customerRepository.deleteById(id);
    }
}
