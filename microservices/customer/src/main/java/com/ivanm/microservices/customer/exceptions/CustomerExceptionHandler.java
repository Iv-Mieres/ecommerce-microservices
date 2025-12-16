package com.ivanm.microservices.customer.exceptions;

import com.ivanm.microservices.exceptions.ErrorResponse;
import com.ivanm.microservices.exceptions.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
@Primary
@RefreshScope
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        var field = "message";
        var message = ex.getMessage();

        log.warn("Customer Not Found Error Message: {}", ex.toString());
        return new ResponseEntity<>(new ErrorResponse(Map.of(field, message)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerAlReadyExist.class)
    public ResponseEntity<ErrorResponse> handleCustomerAlReadyExistException(CustomerAlReadyExist ex) {
        var field = "message";
        var message = ex.getMessage();

        log.warn("Customer Al Ready Exist Error Message: {}", ex.toString());
        return new ResponseEntity<>(new ErrorResponse(Map.of(field, message)), HttpStatus.BAD_REQUEST);
    }
}
