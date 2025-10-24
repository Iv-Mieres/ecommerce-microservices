package com.ivanm.microservices.customer.service;

import com.ivanm.microservices.customer.dto.CustomerDto;
import com.ivanm.microservices.customer.mappper.CustomerMapper;
import com.ivanm.microservices.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCoreService implements CustomerService{


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public String createCustomer(CustomerDto customerDto) {
        var customerEntity = customerMapper.toEntity(customerDto);
        var savedCustomer = customerRepository.save(customerEntity);
        return savedCustomer.getId();
    }
}
