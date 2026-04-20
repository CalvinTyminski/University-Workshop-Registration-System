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
    public String register(@PathVariable Long id,
                           Authentication auth,
                           RedirectAttributes redirect) {

        try {
            registrationService.registerByEmail(id, auth.getName());

            redirect.addFlashAttribute("success", "Registered successfully!");

        } catch (Exception ex) {
            redirect.addFlashAttribute("error", ex.getMessage());
        }

        return "redirect:/my/registrations";
    }

    @PostMapping("/registrations/{id}/cancel")
    public String cancel(@PathVariable Long id,
                         Authentication auth,
                         RedirectAttributes redirect) {

        try {
            registrationService.cancelByEmail(id, auth.getName());

            redirect.addFlashAttribute("success", "Registration cancelled");

        } catch (Exception ex) {
            redirect.addFlashAttribute("error", ex.getMessage());
        }

        return "redirect:/my/registrations";
    }
}