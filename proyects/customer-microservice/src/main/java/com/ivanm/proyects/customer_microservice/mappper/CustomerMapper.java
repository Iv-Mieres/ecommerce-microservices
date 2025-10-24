package com.ivanm.proyects.customer_microservice.mappper;

import com.ivanm.proyects.customer_microservice.dto.CustomerDto;
import com.ivanm.proyects.customer_microservice.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .email(customerDto.email())
                .phoneNumber(customerDto.phoneNumber())
                .address(customerDto.address())
                .city(customerDto.city())
                .build();
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                null,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress(),
                customer.getCity()
        );
    }

}
