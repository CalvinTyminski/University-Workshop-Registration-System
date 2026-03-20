package com.FinalProject.RegistrationSystem.controller;


import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workshops")
public class WorkshopController {

    @Autowired
    private final WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    //Create Workshop
    @PostMapping
    public Workshop createWorkShop(@RequestBody Workshop workshop){
        return workshopService.createWorkshop(workshop);
    }
    //Get all Workshops
    @GetMapping
    public List<Workshop> getAllWorkshops(){
        return workshopService.getAllWorkshops();
    }
    //Get Workshops by Id
    @GetMapping("/{id}")
    public Workshop getWorkshopById(@PathVariable Long id){
        return workshopService.getWorkshopById(id);
    }
    @Transactional
    @DeleteMapping
    public Void deleteWorkshop(@PathVariable Long id){
        workshopService.deleteWorkshop(id);
    }
}
