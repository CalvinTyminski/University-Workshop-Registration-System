package com.FinalProject.RegistrationSystem.dto;

import java.util.Date;

public class CreateRegistrationRequest {
    public Long user_id;

    public Long workshop_id;

    public String status;

    public Date created_at;

    public Date cancelled_at;
}
