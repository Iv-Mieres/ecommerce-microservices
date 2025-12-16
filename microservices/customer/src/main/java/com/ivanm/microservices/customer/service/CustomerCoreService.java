package com.ivanm.microservices.customer.service;

import com.ivanm.microservices.customer.dto.request.CustomerRequest;
import com.ivanm.microservices.customer.dto.response.CustomerResponse;
import com.ivanm.microservices.customer.exceptions.CustomerDataErrorException;
import com.ivanm.microservices.customer.exceptions.CustomerNotFoundException;
import com.ivanm.microservices.customer.mappper.CustomerMapper;
import com.ivanm.microservices.customer.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerCoreService implements CustomerService {

    // Dependencias inyectadas por constructor (pueden ser final)
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Value("${customer.data}")
    private String customerData;


    @Override
    public String createCustomer(CustomerRequest customerDto) {
        if (Objects.isNull(customerDto.id())) {
            var customerEntity = customerMapper.toEntity(customerDto);
            var savedCustomer = customerRepository.save(customerEntity);
            log.info("server port: {}", customerData);
            log.error("probando error log");
            return savedCustomer.getId();
        }else {
            throw new CustomerDataErrorException("The data entered is incorrect.");
        }
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    @Override
    public Page<CustomerResponse> getCustomers(Pageable pageable) {
        var customers = customerRepository.findAll(pageable)
                .map(customerMapper::toDto)
                .toList();
        return new PageImpl<>(customers, pageable, customers.size());
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        if (customerRequest.id() == null || !customerRepository.existsById(customerRequest.id())) {
            throw new CustomerNotFoundException("Customer not found");
        }
        var savedCustomer = customerRepository.save(customerMapper.toEntity(customerRequest));
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        if (id != null) customerRepository.deleteById(id);
    }
}
