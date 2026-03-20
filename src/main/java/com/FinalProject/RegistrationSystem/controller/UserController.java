package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getUsersById(@PathVariable Long id){
        return userService.getById(id);
    }
}
