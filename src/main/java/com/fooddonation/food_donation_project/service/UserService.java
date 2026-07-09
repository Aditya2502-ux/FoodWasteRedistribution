package com.fooddonation.food_donation_project.service;

import com.fooddonation.food_donation_project.model.User;
import com.fooddonation.food_donation_project.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }
}
