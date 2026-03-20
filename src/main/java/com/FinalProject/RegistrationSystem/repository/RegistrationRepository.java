package com.FinalProject.RegistrationSystem.repository;

import com.FinalProject.RegistrationSystem.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    boolean userExists(Long userId, Long WorkshopId);
    List<Registration> findByWorkshopId(Long workshopId);
}
