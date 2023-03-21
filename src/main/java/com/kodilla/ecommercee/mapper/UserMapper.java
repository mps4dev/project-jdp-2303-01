package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDTO> mapToUserDTOList(List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
    }
}
