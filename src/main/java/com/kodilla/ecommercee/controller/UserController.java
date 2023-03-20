package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDTO;
import com.kodilla.ecommercee.domain.dto.UserKeyDTO;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/users")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}/block")
    public ResponseEntity<Void> blockUser(long userId) throws UserNotFoundException {
        userService.blockUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "keygenerate")
    public ResponseEntity<UserKeyDTO> generateKey(long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.generateKey(userId));
    }
}
