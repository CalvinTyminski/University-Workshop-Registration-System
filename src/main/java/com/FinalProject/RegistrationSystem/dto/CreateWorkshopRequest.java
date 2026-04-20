package com.FinalProject.RegistrationSystem.dto;

import com.FinalProject.RegistrationSystem.model.Workshop;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateWorkshopRequest {

    public String title;
    public String description;
    public String location;
    public LocalDateTime start_datetime;
    public int total_seats;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getStart_datetime() { return start_datetime; }
    public void setStart_datetime(LocalDateTime start_datetime) { this.start_datetime = start_datetime; }

    public int getTotal_seats() { return total_seats; }
    public void setTotal_seats(int total_seats) { this.total_seats = total_seats; }
}
