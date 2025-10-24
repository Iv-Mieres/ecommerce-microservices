package com.ivanm.microservices.customer.controller;

import com.ivanm.microservices.customer.dto.request.CustomerRequest;
import com.ivanm.microservices.customer.dto.response.CustomerResponse;
import com.ivanm.microservices.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<CustomerResponse>> getAllCustomer(Pageable pageable) {
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }

    @PutMapping()
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.updateCustomer(customerRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }



}
