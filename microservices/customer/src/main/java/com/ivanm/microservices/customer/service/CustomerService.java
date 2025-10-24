package com.ivanm.microservices.customer.service;

import com.ivanm.microservices.customer.dto.request.CustomerRequest;
import com.ivanm.microservices.customer.dto.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    String createCustomer(@Valid CustomerRequest customerDto);

    CustomerResponse getCustomerById(String id);

    Page<CustomerResponse> getCustomers(Pageable pageable);

    CustomerResponse updateCustomer(@Valid CustomerRequest customerRequest);

    void deleteCustomer(String id);
}
