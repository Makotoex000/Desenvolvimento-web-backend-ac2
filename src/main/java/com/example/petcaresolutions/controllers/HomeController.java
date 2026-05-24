package com.example.petcaresolutions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public Map<String, Object> home() {
        return Map.of(
                "application", "petcaresolutions",
                "message", "Welcome to the Pet Care Solutions API",
                "endpoints", Map.of(
                        "tutores", "/api/tutores",
                        "veterinarios", "/api/veterinarios",
                        "animais", "/api/animais",
                        "consultas", "/api/consultas",
                        "prontuarios", "/api/prontuarios",
                        "vacinas", "/api/vacinas"
                )
        );
    }
}
