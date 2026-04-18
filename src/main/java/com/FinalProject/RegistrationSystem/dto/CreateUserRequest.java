package com.FinalProject.RegistrationSystem.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

public class CreateUserRequest {
    public String name;
    @Valid
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Email is invalid")
    public String email;
    @Valid
    @Min(value = 8, message = "Password must be at least 8 characters")
    public String password_hash;
}
