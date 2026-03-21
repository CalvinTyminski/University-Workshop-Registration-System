package com.FinalProject.RegistrationSystem.repository;

import com.FinalProject.RegistrationSystem.model.Registration;
import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    boolean existsByUserAndWorkshop(User user, Workshop workshop);
    List<Registration> findByWorkshopId(Long workshopId);
    List<Registration> findByUserId(Long userId);
}
