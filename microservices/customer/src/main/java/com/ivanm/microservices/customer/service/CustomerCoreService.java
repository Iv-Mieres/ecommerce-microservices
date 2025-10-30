package com.ivanm.microservices.customer.service;

import com.ivanm.microservices.customer.dto.request.CustomerRequest;
import com.ivanm.microservices.customer.dto.response.CustomerResponse;
import com.ivanm.microservices.customer.exceptions.CustomerAlReadyExist;
import com.ivanm.microservices.customer.exceptions.CustomerNotFoundException;
import com.ivanm.microservices.customer.mappper.CustomerMapper;
import com.ivanm.microservices.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCoreService implements CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public String createCustomer(CustomerRequest customerDto) {
        if (customerRepository.existsById(customerDto.id())) {
            throw new CustomerAlReadyExist("Enter a new Customer.");
        }
        var customerEntity = customerMapper.toEntity(customerDto);
        var savedCustomer = customerRepository.save(customerEntity);
        return savedCustomer.getId();
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
