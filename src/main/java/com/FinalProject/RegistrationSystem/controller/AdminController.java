package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import com.FinalProject.RegistrationSystem.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/workshops")
public class AdminController {

    private final WorkshopService workshopService;
    private final RegistrationService registrationService;

    public AdminController(WorkshopService workshopService,
                           RegistrationService registrationService) {
        this.workshopService = workshopService;
        this.registrationService = registrationService;
    }

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("workshops", workshopService.getAll());
        return "admin/admin-workshops";
    }

    // CREATE PAGE
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("workshop", new CreateWorkshopRequest());
        return "admin/admin-create";
    }

    // CREATE
    @PostMapping
    public String create(@ModelAttribute CreateWorkshopRequest workshop) {
        workshopService.create(workshop);
        return "redirect:/admin/workshops";
    }

    // EDIT PAGE
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("workshop", workshopService.getById(id));
        return "admin/admin-edit";
    }

    // UPDATE
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Workshop workshop) {
        workshopService.update(id, workshop);
        return "redirect:/admin/workshops";
    }

    // CANCEL
    @PostMapping("/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        workshopService.cancelWorkshop(id);
        return "redirect:/admin/workshops";
    }

    // VIEW REGISTRATIONS
    @GetMapping("/{id}/registrations")
    public String registrations(@PathVariable Long id, Model model) {
        model.addAttribute("registrations", registrationService.getAllWorkshopRegistrations(id));
        return "admin/admin-registrations";
    }
}


