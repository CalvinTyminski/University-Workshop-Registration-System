package com.FinalProject.RegistrationSystem.dto;

import com.FinalProject.RegistrationSystem.model.Workshop;

import java.time.LocalDateTime;

public class CreateWorkshopRequest {
    public String title;
    public String description;
    public String location;
    public LocalDateTime start_datetime;
    public int total_seats;
}
