package com.fooddonation.food_donation_project.model;

import com.fooddonation.food_donation_project.enums.DonationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private Integer quantity;

    private String pickupAddress;

    private LocalDateTime expiryTime;

    @Enumerated(EnumType.STRING)
    private DonationStatus status;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
