package com.ivanm.microservices.customer.mappper;

import com.ivanm.microservices.customer.dto.request.CustomerRequest;
import com.ivanm.microservices.customer.dto.response.CustomerResponse;
import com.ivanm.microservices.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest customerDto) {
        return Customer.builder()
                .id(customerDto.id())
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .phoneNumber(customerDto.phoneNumber())
                .address(customerDto.address())
                .city(customerDto.city())
                .build();
    }

    public CustomerResponse toDto(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress(),
                customer.getCity()
        );
    }

}
