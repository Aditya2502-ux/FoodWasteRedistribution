package com.fooddonation.food_donation_project.controller;

import com.fooddonation.food_donation_project.model.User;
import com.fooddonation.food_donation_project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Usercontroller {

    private  final UserService userService;

    public  Usercontroller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerpage(){
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String LoginUser(@RequestBody User user){
        try {
            userService.LoginUser(user.getEmail(),user.getPassword());
            return "Login Successful";
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public  String registerUser(@RequestBody User user){
        try {
            userService.registerUser(user);
            return "User Registered Successfully";
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    @ResponseBody
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return "User deleted successfully";
    }

}
