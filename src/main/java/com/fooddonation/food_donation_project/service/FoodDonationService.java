package com.fooddonation.food_donation_project.service;

import com.fooddonation.food_donation_project.enums.DonationStatus;
import com.fooddonation.food_donation_project.model.FoodDonation;
import com.fooddonation.food_donation_project.repository.FoodDonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDonationService {
    private final FoodDonationRepository foodDonationRepository;

    public FoodDonationService(FoodDonationRepository foodDonationRepository){
        this.foodDonationRepository = foodDonationRepository;
    }

    public FoodDonation createDonation(FoodDonation foodDonation){
        if(foodDonation.getFoodName() == null || foodDonation.getFoodName().trim().isEmpty()){
            throw new RuntimeException("Food name is required.");
        }

        if (foodDonation.getQuantity() <= 0){
            throw new RuntimeException("Quantity must be greater than zero.");
        }

        if(foodDonation.getPickupAddress() == null || foodDonation.getPickupAddress().trim().isEmpty()){
            throw new RuntimeException("Pickup address is required.");
        }

        foodDonation.setStatus(DonationStatus.AVAILABLE);

        return foodDonationRepository.save(foodDonation);
    }

    public List<FoodDonation> getAllDonations(){
        return foodDonationRepository.findAll();
    }

    public FoodDonation getDonationById(Long id){
        return foodDonationRepository.findById(id).orElseThrow(()-> new RuntimeException("Food donation not found"));
    }
}
