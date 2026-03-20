package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateRegistrationRequest;
import com.FinalProject.RegistrationSystem.model.Registration;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.repository.RegistrationRepository;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import com.FinalProject.RegistrationSystem.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    public Registration create(CreateRegistrationRequest request) {
        Workshop workshop = workshopRepository.findById(request.workshop_id)
                .orElseThrow(
                        () -> new RuntimeException("Workshop does not exist")
                );

        Registration registration = new Registration();
        registration.setWorkshop_id(request.workshop_id);
        registration.setUser_id(request.user_id);
        registration.setCreated_at(request.created_at);
        registration.setStatus(request.status);

        return registrationRepository.save(registration);
    }

    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    public Registration getById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Registration does not exist")
                );
    }
}
