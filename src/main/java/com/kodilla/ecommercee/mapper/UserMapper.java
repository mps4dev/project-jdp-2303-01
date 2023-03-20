package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User mapToUser(final UserDTO userDTO) {
        return new User(
                userDTO.getUserId(),
                userDTO.getName(),
                userDTO.getLastName(),
                userDTO.getAddress(),
                userDTO.getLogin(),
                userDTO.getPassword());
    }

public UserDTO mapToUserDTO(final User user) {
      return new UserDTO(
          user.getUserId(),
              user.getName(),
              user.getLastName(),
              user.getAddress(),
              user.getLogin(),
              user.getPassword());
    }
}
