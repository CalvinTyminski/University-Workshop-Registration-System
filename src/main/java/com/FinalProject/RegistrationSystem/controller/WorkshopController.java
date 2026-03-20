package com.FinalProject.RegistrationSystem.controller;


import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.service.WorkshopService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Workshop createWorkShop(@RequestBody CreateWorkshopRequest request){
        return workshopService.create(request);
    }
    //Get all Workshops
    @GetMapping("/api/v1/workshops")
    public List<Workshop> getAllWorkshops(){
        return workshopService.getAll();
    }
    //Get Workshops by Id
    @GetMapping("/api/v1/workshops{id}")
    public Workshop getById(@PathVariable Long id){
        return workshopService.getById(id);
    }


}
