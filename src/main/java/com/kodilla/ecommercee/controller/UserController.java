package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDTO;
import com.kodilla.ecommercee.dto.UserKeyDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/users")
@RestController
@CrossOrigin("*")
public class UserController {
    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}/block")
    public ResponseEntity<Void> blockUser(Long userId){
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "keygenerate")
    public ResponseEntity<UserKeyDTO> generateKey() {
        return ResponseEntity.ok(null);
    }
}