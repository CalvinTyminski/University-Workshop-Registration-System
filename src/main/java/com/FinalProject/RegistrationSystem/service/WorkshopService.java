package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Transactional
    public Workshop create(CreateWorkshopRequest request) {

        if (request.start_datetime.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Workshop must be in the future");
        }

        Workshop workshop = new Workshop();
        workshop.setTitle(request.title);
        workshop.setDescription(request.description);
        workshop.setLocation(request.location);
        workshop.setStart_datetime(request.start_datetime);
        workshop.setStatus(Workshop.workshopStatus.ACTIVE);
        workshop.setTotal_seats(request.total_seats);
        workshop.setSeats_remaining(workshop.getTotal_seats());


        return workshopRepository.save(workshop);
    }

    public List<Workshop> getAll() {
        return workshopRepository.findAll();
    }

    public Workshop getById(Long id) {
        return workshopRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Workshop does not exist")
                );
    }

    @Transactional
    public void cancelWorkshop(Long id) {
        Workshop workshop = workshopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workshop not found"));

        workshop.setStatus(Workshop.workshopStatus.CANCELLED);
    }
}
