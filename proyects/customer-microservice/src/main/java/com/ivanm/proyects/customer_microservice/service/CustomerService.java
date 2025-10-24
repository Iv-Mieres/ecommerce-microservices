package com.ivanm.proyects.customer_microservice.service;

import com.ivanm.proyects.customer_microservice.dto.CustomerDto;
import jakarta.validation.Valid;

public interface CustomerService {
    String createCustomer(@Valid CustomerDto customerDto);
}
