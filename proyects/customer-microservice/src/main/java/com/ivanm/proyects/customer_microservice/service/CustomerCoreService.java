package com.ivanm.proyects.customer_microservice.service;

import com.ivanm.proyects.customer_microservice.dto.CustomerDto;
import com.ivanm.proyects.customer_microservice.mappper.CustomerMapper;
import com.ivanm.proyects.customer_microservice.repository.CustomerRepository;
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
