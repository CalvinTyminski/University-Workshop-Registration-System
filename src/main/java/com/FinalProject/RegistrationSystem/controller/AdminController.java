package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.Registration;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.RegistrationService;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/workshops")
public class AdminController {

    @Autowired
    private WorkshopService workshopService;

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Workshop create(@RequestBody CreateWorkshopRequest request) {
        return workshopService.create(request);
    }

    @PutMapping("/{id}")
    public Workshop update(@PathVariable Long id, @RequestBody Workshop updated) {
        return workshopService.update(id, updated);
    }

    @PatchMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        workshopService.cancelWorkshop(id);
    }

    @GetMapping("/{id}/registrations")
    public List<Registration> getRegistrations(@PathVariable Long id) {
        return registrationService.getAllWorkshopRegistrations(id);
    }
}

