package com.FinalProject.RegistrationSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    public User user;

    @ManyToOne
    @JoinColumn(name = "workshop_id", unique = true)
    public Workshop workshop;

    public enum status {
        ACTIVE,
        CANCELLED
    }

    public LocalDateTime created_at;

    public LocalDateTime cancelled_at;

}
