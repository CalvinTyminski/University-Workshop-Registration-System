package com.FinalProject.RegistrationSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    @NotBlank(message = "Name is required")
    public String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    public String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    public String password;
}