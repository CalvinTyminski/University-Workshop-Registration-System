package com.FinalProject.RegistrationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Workshop {

    @Id
    @GeneratedValue
    public Long id;
    public String title;
    public String description;
    public String location;
    public String start_datetime;
    public int total_seats;
    public int seats_remaining;
    public String status;

}
