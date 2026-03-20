package com.FinalProject.RegistrationSystem.repository;

import com.FinalProject.RegistrationSystem.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
