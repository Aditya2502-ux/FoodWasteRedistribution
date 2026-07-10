package com.fooddonation.food_donation_project.service;

import com.fooddonation.food_donation_project.model.User;
import com.fooddonation.food_donation_project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){

        Optional<User> existingUser = userRepository.findByEmail((user.getEmail()));

        if (existingUser.isPresent()){
            throw new RuntimeException("Email already registered.");
        }
        return userRepository.save(user);
    }
}
