package com.ivanm.microservices.customer.controller;

import com.ivanm.microservices.customer.dto.CustomerDto;
import com.ivanm.microservices.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }



}
