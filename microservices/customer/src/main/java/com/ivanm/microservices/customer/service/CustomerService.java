package com.ivanm.microservices.customer.service;

import com.ivanm.microservices.customer.dto.CustomerDto;
import jakarta.validation.Valid;

public interface CustomerService {
    String createCustomer(@Valid CustomerDto customerDto);
}
