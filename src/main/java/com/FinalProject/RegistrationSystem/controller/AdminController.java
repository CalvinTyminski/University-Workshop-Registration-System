package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.dto.WorkshopForm;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import com.FinalProject.RegistrationSystem.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping
    public String list(Model model) {
        model.addAttribute("workshops", workshopService.getAll());
        return "admin/admin-workshops";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("workshop", new WorkshopForm());
        return "admin/admin-create";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute CreateWorkshopRequest workshop,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect) {

        if (result.hasErrors()) {
            model.addAttribute("workshop", workshop);
            return "admin/admin-create";
        }

        try {
            workshopService.create(workshop);

            redirect.addFlashAttribute("success", "Workshop created!");

            return "redirect:/admin/workshops";

        } catch (Exception ex) {
            redirect.addFlashAttribute("error", ex.getMessage());
            return "redirect:/admin/workshops/new";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("workshop", workshopService.getById(id));
        return "admin/admin-edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Workshop workshop) {
        workshopService.update(id, workshop);
        return "redirect:/admin/workshops";
    }

    @PostMapping("/{id}/cancel")
    public String cancel(@PathVariable Long id) {
        workshopService.cancelWorkshop(id);
        return "redirect:/admin/workshops";
    }

    @GetMapping("/{id}/registrations")
    public String registrations(@PathVariable Long id, Model model) {
        model.addAttribute("registrations", registrationService.getAllWorkshopRegistrations(id));
        return "admin/admin-registrations";
    }
}


