package com.fooddonation.food_donation_project.repository;

import com.fooddonation.food_donation_project.model.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDonationRepository extends JpaRepository<FoodDonation, Long> {

}
