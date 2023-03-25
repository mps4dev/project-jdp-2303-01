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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/users")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{userId}/block")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> blockUser(@PathVariable long userId) throws UserNotFoundException {
        userService.blockUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{userId}/keygenerate")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<UserKeyDTO> generateKey(@PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userService.generateKey(userId));
    }

    @GetMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> userList = userService.showUsers();
        return ResponseEntity.ok(userMapper.mapToUserDTOList(userList));
    }
}
