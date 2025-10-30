package com.ivanm.microservices.customer.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerAlReadyExist extends RuntimeException{
    private final String message;
}
