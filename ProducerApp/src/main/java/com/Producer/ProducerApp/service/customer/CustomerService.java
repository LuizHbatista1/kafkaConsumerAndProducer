package com.Producer.ProducerApp.service.customer;

import com.Producer.ProducerApp.DTOS.CustomerDTO;
import com.Producer.ProducerApp.domain.Customer;
import com.Producer.ProducerApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerService implements CustomerServiceInterface {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(Long id){

        return this.customerRepository.findById(id).orElseThrow(RuntimeException::new);

    }

    @Override
    public Customer createAndSaveCustomer(CustomerDTO customerDTO){

        Customer newCustomer = new Customer(customerDTO);
        newCustomer.setName(newCustomer.getName());
        newCustomer.setDocument(newCustomer.getDocument());
        newCustomer.setScore(generateRandomScore());
        this.customerRepository.save(newCustomer);
        return newCustomer;

    }

    @Override
    public Integer generateRandomScore(){

        Random random = new Random();
        Integer score = random.nextInt(1000);
        return score;


    }

}
