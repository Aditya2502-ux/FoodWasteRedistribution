package com.fooddonation.food_donation_project.model;

import com.fooddonation.food_donation_project.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
