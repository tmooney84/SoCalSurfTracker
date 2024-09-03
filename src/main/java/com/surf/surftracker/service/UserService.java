package com.surf.surftracker.service;

import com.surf.surftracker.model.User;
import com.surf.surftracker.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);

    }

    Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
