package com.Producer.ProducerApp.controller;

import com.Producer.ProducerApp.DTOS.CustomerDTO;
import com.Producer.ProducerApp.domain.Customer;
import com.Producer.ProducerApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer>createCustomer(@RequestBody CustomerDTO customerDTO){

        Customer newCustomer = customerService.createAndSaveCustomer(customerDTO);
        return new ResponseEntity<>(newCustomer , HttpStatus.CREATED);


    }

}
