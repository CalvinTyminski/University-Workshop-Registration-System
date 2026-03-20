package com.FinalProject.RegistrationSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "workshop_id"})
)
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workshop_id", nullable = false)
    private Workshop workshop;

    @Enumerated(EnumType.STRING)
    private registrationStatus registrationStatus;

    public enum registrationStatus {
        ACTIVE,
        CANCELLED
    }

    private LocalDateTime created_at;

    private LocalDateTime cancelled_at;

}
