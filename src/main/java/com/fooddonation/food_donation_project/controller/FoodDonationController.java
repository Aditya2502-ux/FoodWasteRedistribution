package com.fooddonation.food_donation_project.controller;

import com.fooddonation.food_donation_project.model.FoodDonation;
import com.fooddonation.food_donation_project.service.FoodDonationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<FoodDonation> getAllDonations(){
        return foodDonationService.getAllDonations();
    }

    @GetMapping("/{id}")
    public FoodDonation getDonationById(@PathVariable Long id){
        return foodDonationService.getDonationById(id);
    }

    @PutMapping("/{id}")
    public FoodDonation updateDonation(@PathVariable Long id, @RequestBody FoodDonation foodDonation){
        return foodDonationService.updateDonation(id, foodDonation);
    }
}
