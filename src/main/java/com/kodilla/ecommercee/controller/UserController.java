package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.UserDTO;
import com.kodilla.ecommercee.domain.dto.UserKeyDTO;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/users")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{userId}/block")
    public ResponseEntity<Void> blockUser(@PathVariable long userId) throws UserNotFoundException {
        userService.blockUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{userId}/keygenerate")
    public ResponseEntity<UserKeyDTO> generateKey(@PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.generateKey(userId));
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.showUsers());
    }
}
