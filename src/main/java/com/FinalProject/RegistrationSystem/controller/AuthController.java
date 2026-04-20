package com.FinalProject.RegistrationSystem.controller;

import com.FinalProject.RegistrationSystem.dto.CreateUserRequest;
import com.FinalProject.RegistrationSystem.dto.RegisterForm;
import com.FinalProject.RegistrationSystem.model.User;
import com.FinalProject.RegistrationSystem.repository.UserRepository;
import com.FinalProject.RegistrationSystem.security.user.CustomUserDetailsService;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          CustomUserDetailsService userDetailsService,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("user")RegisterForm form,
            BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setName(form.name);
        user.setEmail(form.email);
        user.setPassword(passwordEncoder.encode(form.password));
        user.setRole(User.Role.ATTENDEE);

        userRepository.save(user);

        return "redirect:/login";
    }

}


