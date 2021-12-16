package com.customer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table
public class Customer {

    @Id
    private Integer customerId;
    private String name;

    public Customer() {
    }

    public Customer(Integer customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

