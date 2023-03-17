package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;
    private User user;
    private User user2;

    private void prepareTestData() {
        user = new User(null, "name", "lastName", "address", "login", "password");
        user2 = new User(null, "name2", "lastName2", "address2", "login2", "password2");
    }

    @Test
    public void testShouldSaveUser() {
        //Given
        prepareTestData();
        //When
        User savedUser = userRepository.save(user);
        User savedUser2 = userRepository.save(user2);
        //Then
        assertThat(savedUser.getName()).isEqualTo("name");
        assertThat(savedUser2.getName()).isEqualTo("name2");
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testShouldFindUsers() {
        //Given
        prepareTestData();
        //When
        User savedUser = userRepository.save(user);
        User savedUser2 = userRepository.save(user2);
        List<User> foundUsers = userRepository.findAll();
        //Then
        assertEquals(2, foundUsers.size());
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testShouldUpdateUser() {
        //Given
        prepareTestData();
        //When
        userRepository.save(user);
        String updatedName = "updatedUserName";
        user = new User(null, updatedName, user.getLastName(), user.getAddress(), user.getLogin(), user.getPassword());
        User updatedUser = userRepository.save(user);
        //Then
        assertThat(updatedUser.getName()).isEqualTo("updatedUserName");
        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testShouldBlockUser() {
        //Given
        prepareTestData();
        //When
        userRepository.save(user);
        user.setBlocked(true);
        userRepository.save(user);
        //Then
        assertTrue(user.isBlocked());
        //CleanUp
        userRepository.deleteAll();
    }
}
