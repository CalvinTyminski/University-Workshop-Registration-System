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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStart_datetime() {
        return start_datetime;
    }

    public void setStart_datetime(LocalDateTime start_datetime) {
        this.start_datetime = start_datetime;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }
}
