package com.ivanm.proyects.customer_microservice.repository;

import com.ivanm.proyects.customer_microservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
