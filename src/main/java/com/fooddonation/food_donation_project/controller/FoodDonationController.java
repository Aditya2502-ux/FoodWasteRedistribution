package com.fooddonation.food_donation_project.controller;

import com.fooddonation.food_donation_project.model.FoodDonation;
import com.fooddonation.food_donation_project.service.FoodDonationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donations")
public class FoodDonationController {

    private final FoodDonationService foodDonationService;

    public FoodDonationController(FoodDonationService foodDonationService){
        this.foodDonationService = foodDonationService;
    }

    @PostMapping
    public FoodDonation createDonation(@RequestBody FoodDonation foodDonation){
        return foodDonationService.createDonation(foodDonation);
    }
}
