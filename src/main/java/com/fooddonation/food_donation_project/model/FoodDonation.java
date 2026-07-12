package com.fooddonation.food_donation_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_donation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;

    private String foodType;

    private String pickupAddress;

    private String expiryTime;

    @Enumerated(EnumType.STRING)
    private String status;

    private String donor;

    private String createdAt;
}
