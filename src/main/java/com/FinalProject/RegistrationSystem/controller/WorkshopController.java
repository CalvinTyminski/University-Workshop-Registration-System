package com.FinalProject.RegistrationSystem.controller;


import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping
    public List<Workshop> getAllWorkshops(){
        return workshopService.getAll();
    }

    @GetMapping("/{id}")
    public Workshop getWorkshopById(@PathVariable Long id){
        return workshopService.getById(id);
    }


}
