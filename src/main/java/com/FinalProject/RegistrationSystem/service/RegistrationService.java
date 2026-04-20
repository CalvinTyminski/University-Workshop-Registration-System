package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateRegistrationRequest;
import com.FinalProject.RegistrationSystem.exception.BadRequestException;
import com.FinalProject.RegistrationSystem.exception.ConflictException;
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
    public Registration registerByEmail(Long id, String email) {
        Workshop workshop = workshopRepository.findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Workshop does not exist")
                );

        User user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new BadRequestException("User does not exist")
                );

        System.out.println("USER ID FROM DB: " + user.getId());

        if (workshop.getSeats_remaining()<=0) {
            throw new ConflictException("Workshop is full");
        }

        if (workshop.getStart_datetime().isBefore(LocalDateTime.now())) {
            throw new ConflictException("Cannot register for past workshop");
        }

        if (registrationRepository.existsByUserAndWorkshop(user, workshop)) {
            throw new ConflictException("User already registered for this workshop");
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
    public Registration cancelByEmail(Long registrationId, String email) {
        Registration registration = registrationRepository.findById(registrationId)
                .orElseThrow(
                        () -> new BadRequestException("Registration not found")
                );

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("User not found"));


        if (!registration.getUser().getId().equals(user.getId())) {
            throw new BadRequestException("You can only cancel your own registrations");
        }

        Workshop workshop = registration.getWorkshop();

        if(workshop.getStart_datetime().isBefore(LocalDateTime.now())){
            throw new BadRequestException("Workshop already started");
        }

        registration.setRegistrationStatus(Registration.registrationStatus.CANCELLED);
        registration.setCancelled_at(LocalDateTime.now());

        workshop.setSeats_remaining(workshop.getSeats_remaining() +1);

        workshopRepository.save(workshop);

        return registrationRepository.save(registration);
    }

    public List<Registration> getAllWorkshopRegistrations(Long workshopId) {
        return registrationRepository.findByWorkshopId(workshopId);
    }

    public List<Registration> getAllUserRegistrations(Long userId) {
        return registrationRepository.findByUserId(userId);
    }

    public List<Registration> getAllUserRegistrationsByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return registrationRepository.findByUserId(user.getId());
    }
}
