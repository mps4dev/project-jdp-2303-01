package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserKey;
import com.kodilla.ecommercee.domain.dto.UserKeyDTO;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserKeyMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserKeyMapper userKeyMapper;

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void blockUser(final long userId) throws UserNotFoundException {
        User foundUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        foundUser.setBlocked(true);
        userRepository.save(foundUser);
    }
    public UserKeyDTO generateKey(final long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Random random = new Random();
        UserKey key = new UserKey(random.nextLong(), Instant.now().plus(Duration.ofHours(1)));
        user.setUserKey(key);
        userRepository.save(user);
        return userKeyMapper.mapToUserKeyDTO(user.getUserKey());
    }
}
