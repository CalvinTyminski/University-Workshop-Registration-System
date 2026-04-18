package com.FinalProject.RegistrationSystem.dto;

import jakarta.persistence.Column;

public class CreateUserRequest {
    public String name;
    public String email;
    public String password_hash;
}
