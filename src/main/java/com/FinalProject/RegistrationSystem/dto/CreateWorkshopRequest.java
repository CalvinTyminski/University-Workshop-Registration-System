package com.FinalProject.RegistrationSystem.dto;

import com.FinalProject.RegistrationSystem.model.Workshop;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateWorkshopRequest {
    @Valid
    @NotBlank(message = "Title must not be blank")
    public String title;
    public String description;
    @Valid
    @NotBlank(message = "Location must not be blank")
    public String location;
    @Valid
    @NotNull(message = "Start date must not be empty")
    @Future(message = "Start date must be in the future")
    public LocalDateTime start_datetime;
    @Valid
    @Min(value = 1, message = "Quantity must be at least 1")
    public int total_seats;
}
