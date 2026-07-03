package com.fooddonation.food_donation_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Usercontroller {

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
    public  String registerUser(){

        return "User Registered Successfully";
    }

}
