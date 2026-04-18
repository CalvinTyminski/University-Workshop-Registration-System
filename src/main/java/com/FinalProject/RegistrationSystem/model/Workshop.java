package com.FinalProject.RegistrationSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDateTime start_datetime;
    private int total_seats;
    private int seats_remaining;
    @Enumerated(EnumType.STRING)
    private workshopStatus workshopStatus;
    public enum workshopStatus {
        ACTIVE,
        CANCELLED
    }

}
