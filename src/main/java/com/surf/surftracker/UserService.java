package com.surf.surftracker;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> findAll(){
        return userRepository.findAll();
    }

    User save(User user){
        return userRepository.save(user);

    }

    Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
