package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.cadatroAnimal;
import com.example.petcaresolutions.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<cadatroAnimal> create(@RequestBody cadatroAnimal animal) {
        cadatroAnimal saved = service.save(animal);
        return ResponseEntity.created(URI.create("/api/animais/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<cadatroAnimal> list() {
        return service.findAll();
    }

    @GetMapping("/especie/{especie}")
    public List<cadatroAnimal> byEspecie(@PathVariable String especie) {
        return service.findByEspecie(especie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<cadatroAnimal> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
