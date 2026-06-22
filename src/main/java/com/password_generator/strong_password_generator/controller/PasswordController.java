package com.password_generator.strong_password_generator.controller;

import com.password_generator.strong_password_generator.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/generate")
    public String generatePassword()
    {
        return passwordService.generateStrongPassword();
    }
    
}

