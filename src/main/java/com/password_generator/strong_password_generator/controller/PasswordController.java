package com.password_generator.strong_password_generator.controller;

import com.password_generator.strong_password_generator.dto.PasswordResponse;
import com.password_generator.strong_password_generator.service.PasswordGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordController {

    private final PasswordGeneratorService service;

    public PasswordController(PasswordGeneratorService service) {
        this.service = service;
    }

    @GetMapping("/generate")
    public ResponseEntity<PasswordResponse> generate(@RequestParam(defaultValue = "16") int length) {
        return ResponseEntity.ok(new PasswordResponse(service.generate(length), length));
    }
}