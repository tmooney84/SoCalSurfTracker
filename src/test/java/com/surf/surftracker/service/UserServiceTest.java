package com.surf.surftracker.service;

import com.surf.surftracker.model.User;
import com.surf.surftracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*
        @Test
        void testFindAll() {
            // Arrange
            User user1 = new User("username1", "password1");
            User user2 = new User("username2", "password2");
            when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

            // Act
            List<User> users = userService.findAll();

            // Assert
            assertEquals(2, users.size());
            assertTrue(users.contains(user1));
            assertTrue(users.contains(user2));
        }
    }
    */
    @Test
    void testSave() {
        // Arrange
        User user = new User("username", "password");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User savedUser = userService.save(user);

        // Assert
        assertEquals(user, savedUser);
        verify(userRepository).save(user);
    }
}
/*
    @Test
    void testFindByUsername() {
        // Arrange
        User user = new User("username", "password");
        when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));

        // Act
        Optional<User> foundUser = userService.findByUsername("username");

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }

    @Test
    void testFindByUsernameNotFound() {
        // Arrange
        when(userRepository.findByUsername("unknown")).thenReturn(Optional.empty());

        // Act
        Optional<User> foundUser = userService.findByUsername("unknown");

        // Assert
        assertTrue(foundUser.isEmpty());
    }
}
*/