package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long userId);
    User save(User user);
    List<User> findAll();
}
