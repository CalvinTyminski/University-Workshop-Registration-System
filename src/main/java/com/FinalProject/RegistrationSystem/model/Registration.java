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
public class Registration {

    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String email;
    public String password_hash;
    public String role;
}
