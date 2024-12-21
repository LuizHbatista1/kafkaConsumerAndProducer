package com.Producer.ProducerApp.service.customer;

import com.Producer.ProducerApp.DTOS.CustomerDTO;
import com.Producer.ProducerApp.domain.Customer;

public interface CustomerServiceInterface {

    Customer createAndSaveCustomer(CustomerDTO customerDTO);

    Customer findCustomerById(Long id);

    Integer generateRandomScore();




}
