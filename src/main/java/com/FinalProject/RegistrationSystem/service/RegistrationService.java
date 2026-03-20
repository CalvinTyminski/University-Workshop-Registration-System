package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateRegistrationRequest;
import com.FinalProject.RegistrationSystem.model.Registration;
import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.repository.RegistrationRepository;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import com.FinalProject.RegistrationSystem.repository.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkshopRepository workshopRepository;

    @Transactional
    public Registration register(CreateRegistrationRequest request) {
        Workshop workshop = workshopRepository.findById(request.workshop_id)
                .orElseThrow(
                        () -> new RuntimeException("Workshop does not exist")
                );

        User user = userRepository.findById(request.user_id)
                .orElseThrow(
                        () -> new RuntimeException("User does not exist")
                );

        if (workshop.getSeats_remaining()<=0) {
            throw new RuntimeException("Workshop is full");
        }

        if (workshop.getStart_datetime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Workshop must be in the future");
        }

        if (registrationRepository.existsByUserAndWorkshop(request.user_id, request.workshop_id)) {
            throw new RuntimeException("User already registered for this workshop");
        }


        Registration registration = new Registration();
        registration.setWorkshop(workshop);
        registration.setUser(user);
        registration.setCreated_at(LocalDateTime.now());

        registration.setRegistrationStatus(Registration.registrationStatus.ACTIVE);
        workshop.setSeats_remaining(workshop.getSeats_remaining()-1);
        return registrationRepository.save(registration);
    }

    @Transactional
    public void cancelRegistration(Long registrationId, Long userId) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(
                        () -> new RuntimeException("Registration not found")
                );

        Workshop workshop = registration.getWorkshop();

        if(workshop.getStart_datetime().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Workshop already started");
        }

        registration.setRegistrationStatus(Registration.registrationStatus.CANCELLED);
        registration.setCancelled_at(LocalDateTime.now());

        workshop.setSeats_remaining(workshop.getSeats_remaining() +1);
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

    public List<Registration> getAllWorkshopRegistrations(Long workshopId) {
        return registrationRepository.findByWorkshopId(workshopId);
    }

    public List<Registration> getAllUserRegistrations(Long userId) {
        return registrationRepository.findByUserId(userId);
    }
}
