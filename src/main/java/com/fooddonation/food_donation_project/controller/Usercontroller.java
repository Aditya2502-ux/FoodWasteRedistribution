package com.fooddonation.food_donation_project.controller;

import com.fooddonation.food_donation_project.model.User;
import com.fooddonation.food_donation_project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
