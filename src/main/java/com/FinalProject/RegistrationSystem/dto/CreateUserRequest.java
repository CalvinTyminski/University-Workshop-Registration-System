package com.FinalProject.RegistrationSystem.dto;

import com.FinalProject.RegistrationSystem.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    public String password;

    @Enumerated(EnumType.STRING)
    private User.Role role;

    public enum Role {
        ADMIN,
        ATTENDEE
    }
}
