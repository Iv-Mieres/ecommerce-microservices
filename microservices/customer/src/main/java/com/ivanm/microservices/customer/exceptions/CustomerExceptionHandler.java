package com.ivanm.microservices.customer.exceptions;

import com.ivanm.microservices.exceptions.ErrorResponse;
import com.ivanm.microservices.exceptions.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
@Primary
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        var field = "message";
        var message = ex.getMessage();
        return new ResponseEntity<>(new ErrorResponse(Map.of(field, message)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerAlReadyExist.class)
    public ResponseEntity<ErrorResponse> handleCustomerAlReadyExistException(CustomerAlReadyExist ex) {
        var field = "message";
        var message = ex.getMessage();
        return new ResponseEntity<>(new ErrorResponse(Map.of(field, message)), HttpStatus.BAD_REQUEST);
    }
}
