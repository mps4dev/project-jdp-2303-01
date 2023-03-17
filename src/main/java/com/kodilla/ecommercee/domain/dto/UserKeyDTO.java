package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;


@AllArgsConstructor
@Getter
public class UserKeyDTO {
    private long value;
    private Instant expirationTime;
}
