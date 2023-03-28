package com.kodilla.ecommercee.exception;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    private Product product;


    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Object>handleCartNotFoundException(CartNotFoundException cartNotFoundException){
        return new ResponseEntity<>("Cart with given Id not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<Object>handleGroupNotFoundException(GroupNotFoundException groupNotFoundException){
        return new ResponseEntity<>("Group with given Id not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object>handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        return new ResponseEntity<>("Order with given Id not found",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object>handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        return new ResponseEntity<>("Product with given Id not found",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object>handleUserNotFoundException(UserNotFoundException UserNotFoundException){
        return new ResponseEntity<>("User with given Id not found",HttpStatus.BAD_REQUEST);
    }


}
