package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateRegistrationRequest;
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
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/workshops/{id}/registrations")
    public Registration register(@RequestBody CreateRegistrationRequest request){
        return registrationService.register(request);

    }
    @GetMapping("/registrations")
    public List<Registration> getRegistrations(){
        return registrationService.getAll();
    }

    @GetMapping("/registrations/{id}")
    public Registration getRegistrationsById(@PathVariable Long id){
        return registrationService.getById(id);
    }
    @Transactional
    @DeleteMapping("/registrations/{registrationId}")
    public void deleteRegistration(@PathVariable Long id){
        registrationService.cancelRegistration(id);
    }
}
