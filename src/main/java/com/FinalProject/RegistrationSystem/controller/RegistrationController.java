package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateRegistrationRequest;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.RegistrationService;
import com.FinalProject.RegistrationSystem.model.Registration;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/workshops/{id}/registrations")
    public Registration register(@PathVariable Long id, @RequestParam Long userId){
        return registrationService.register(id, userId);
    }

    @GetMapping("/me/registrations")
    public List<Registration> getMyRegistrations(@RequestParam Long userId){
        return registrationService.getAllUserRegistrations(userId);
    }

    @DeleteMapping("/registrations/{registrationId}")
    public Registration cancelRegistration(@PathVariable Long registrationId, @RequestParam Long userId){
        return registrationService.cancelRegistration(registrationId, userId);
    }
}
