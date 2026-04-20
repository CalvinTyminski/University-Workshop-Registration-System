package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.service.WorkshopService;
import com.FinalProject.RegistrationSystem.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final WorkshopService workshopService;
    private final RegistrationService registrationService;

    public PageController(WorkshopService workshopService,
                          RegistrationService registrationService) {
        this.workshopService = workshopService;
        this.registrationService = registrationService;
    }

    // HOME PAGE
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("workshops", workshopService.getAll());
        return "home";
    }

    // WORKSHOP DETAILS
    @GetMapping("/workshops/{id}")
    public String workshopDetails(@PathVariable Long id, Model model) {
        model.addAttribute("workshop", workshopService.getById(id));
        return "workshop-details";
    }

    // LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // REGISTER PAGE
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new com.FinalProject.RegistrationSystem.model.User());
        return "register";
    }

    @GetMapping("/my/registrations")
    public String myRegistrations(org.springframework.security.core.Authentication auth, Model model) {
        String email = auth.getName(); // logged-in user

        model.addAttribute("registrations",
                registrationService.getAllUserRegistrationsByEmail(email));

        return "my-registrations";
    }


}