package com.FinalProject.RegistrationSystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue
    public Long id;

    public Long user_id;

    public Long workshop_id;

    public String status;

    public Date created_at;

    public Date cancelled_at;

}
