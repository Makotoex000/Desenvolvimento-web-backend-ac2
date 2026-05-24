package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.vacina;
import com.example.petcaresolutions.services.VacinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    private final VacinaService service;

    public VacinaController(VacinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<vacina> create(@RequestBody vacina vacina) {
        vacina saved = service.save(vacina);
        return ResponseEntity.created(URI.create("/api/vacinas/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<vacina> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<vacina> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/animal/{animalId}")
    public List<vacina> findByAnimal(@PathVariable Long animalId) {
        return service.findByAnimalId(animalId);
    }

    @GetMapping("/tutor/{tutorId}")
    public List<vacina> findByTutor(@PathVariable Long tutorId) {
        return service.findByTutorId(tutorId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<vacina> update(@PathVariable Long id, @RequestBody vacina vacina) {
        return service.findById(id)
                .map(existing -> {
                    vacina.setId(id);
                    return ResponseEntity.ok(service.save(vacina));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
