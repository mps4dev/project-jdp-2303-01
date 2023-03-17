package com.kodilla.ecommercee;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class EcommerceeApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(EcommerceeApplication.class, args);
    }
}

