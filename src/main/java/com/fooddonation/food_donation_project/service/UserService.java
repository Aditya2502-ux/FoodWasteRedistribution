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
        if(user.getFullName() == null || user.getFullName().trim().isEmpty()){
            throw  new RuntimeException(("Full name is required."));
        }
        if(user.getEmail() == null || user.getEmail().trim().isEmpty()){
            throw  new RuntimeException("Email is required.");
        }
        if(user.getPassword() == null || user.getPassword().length()< 6){
            throw  new RuntimeException("Password must be at least 6 characters.");
        }
        if(user.getPhone() == null || !user.getPhone().matches("\\d{10}")){
            throw new RuntimeException(("Phone number must contain exactly 10 digits."));
        }

        Optional<User> existingUser = userRepository.findByEmail((user.getEmail()));

        if (existingUser.isPresent()){
            throw new RuntimeException("Email already registered.");
        }
        return userRepository.save(user);
    }

    public  User LoginUser(String email, String password){
        Optional<User> existingUser = userRepository.findByEmail(email);

        if(existingUser.isEmpty()){
            throw new RuntimeException("Invalid email or password");
        }

        User user = existingUser.get();

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid email or password.");
        }
        return user;
    }
}
