package com.kodilla.ecommercee.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("auditor name");
    }
}
