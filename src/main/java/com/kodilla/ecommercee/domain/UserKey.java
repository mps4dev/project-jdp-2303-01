package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.Instant;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserKey extends Auditable {
    private Long value;
    private Instant expirationTime;
}
