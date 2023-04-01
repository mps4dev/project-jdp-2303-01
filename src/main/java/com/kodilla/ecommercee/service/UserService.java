package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserKey;
import com.kodilla.ecommercee.domain.dto.UserDTO;
import com.kodilla.ecommercee.domain.dto.UserKeyDTO;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserKeyMapper;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserKeyMapper userKeyMapper;
    private final UserMapper userMapper;

    public User saveUser(final UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        return userRepository.save(user);
    }

    public void blockUser(final long userId) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            User foundUser = userRepository.findById(userId).get();
            foundUser.setBlocked(true);
            userRepository.save(foundUser);
        } else {
            System.out.println("User with ID " + userId + " not found");
            throw new UserNotFoundException();
        }
    }

    public UserKeyDTO generateKey(final long userId) throws UserNotFoundException {
        if (userRepository.existsById(userId)) {
            User user = userRepository.findById(userId).get();
            Random random = new Random();
            UserKey key = new UserKey(random.nextLong(), Instant.now().plus(Duration.ofHours(1)));
            user.setUserKey(key);
            userRepository.save(user);
            return userKeyMapper.mapToUserKeyDTO(user.getUserKey());
        } else {
            System.out.println("User with ID " + userId + " not found");
            throw new UserNotFoundException();
        }
    }

    public List<UserDTO> showUsers() {
        return userMapper.mapToUserDTOList(userRepository.findAll());
    }
}
