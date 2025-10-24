package com.ivanm.microservices.customer.dto.response;

public record CustomerResponse(

        String id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String address,
        String city
) {
}
