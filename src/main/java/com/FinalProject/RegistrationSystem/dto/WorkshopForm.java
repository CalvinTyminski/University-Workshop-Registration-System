package com.FinalProject.RegistrationSystem.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class WorkshopForm {
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 80, message = "Title must be 5–80 characters")
    public String title;

    @NotBlank(message = "Description is required")
    public String description;

    @NotBlank(message = "Location is required")
    public String location;

    @NotNull(message = "Start date is required")
    @Future(message = "Workshop must be in the future")
    public LocalDateTime start_datetime;

    @Min(value = 1, message = "Minimum 1 seat required")
    public int total_seats;
}
