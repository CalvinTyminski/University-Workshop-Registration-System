package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.repository.RegistrationRepository;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import com.FinalProject.RegistrationSystem.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkshopService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    @Transactional
    public Workshop create(CreateWorkshopRequest request) {

        Workshop workshop = new Workshop();
        workshop.setTitle(request.title);
        workshop.setDescription(request.description);
        workshop.setLocation(request.location);
        workshop.setStart_datetime(request.start_datetime);
        workshop.setStatus(request.status);
        workshop.setTotal_seats(request.total_seats);
        workshop.setSeats_remaining(request.seats_remaining);


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
    public void deleteWorkshop(Long id) {
        if (workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
        }
    }
}
