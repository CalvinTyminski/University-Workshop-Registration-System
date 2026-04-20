package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.service.RegistrationService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping("/workshops/{id}/register")
    public String register(@PathVariable Long id, Authentication authentication, RedirectAttributes redirect) {
        System.out.println("LOGGED IN USER: " + authentication.getName());
        String email = authentication.getName();

        registrationService.registerByEmail(id, email);
        redirect.addFlashAttribute("success", "Registration successful!");

        return "redirect:/my/registrations";
    }


    @PostMapping("/registrations/{id}/cancel")
    public String cancel(@PathVariable ("id") Long registrationId, Authentication authentication) {

        String email = authentication.getName();
        registrationService.cancelByEmail(registrationId, email);
        return "redirect:/my/registrations";
    }
}