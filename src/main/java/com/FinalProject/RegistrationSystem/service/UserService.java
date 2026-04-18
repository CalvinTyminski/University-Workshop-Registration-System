package com.FinalProject.RegistrationSystem.service;

import com.FinalProject.RegistrationSystem.dto.CreateUserRequest;
import com.FinalProject.RegistrationSystem.dto.CreateWorkshopRequest;
import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.model.Workshop;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword_hash(request.password_hash);
        user.setRole(User.Role.ATTENDEE);

        return userRepository.save(user);
    }

}
