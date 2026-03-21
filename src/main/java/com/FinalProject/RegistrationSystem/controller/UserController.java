package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateUserRequest;
import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import com.FinalProject.RegistrationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

}