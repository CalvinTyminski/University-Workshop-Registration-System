package com.FinalProject.RegistrationSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;



@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private String password_hash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN,
        ATTENDEE

    }
}
