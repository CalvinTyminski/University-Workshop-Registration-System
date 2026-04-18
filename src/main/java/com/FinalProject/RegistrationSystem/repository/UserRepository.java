package com.FinalProject.RegistrationSystem.repository;

import com.FinalProject.RegistrationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
