package com.ivanm.microservices.customer.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        String id,
        @NotNull(message = "First name cannot be null")
        String firstName,
        @NotNull(message = "Last name cannot be null")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,
        String phoneNumber,
        String address,
        String city

) {
}
