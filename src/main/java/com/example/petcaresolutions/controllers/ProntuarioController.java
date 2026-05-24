package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.prontuario;
import com.example.petcaresolutions.services.ProntuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<prontuario> create(@RequestBody prontuario prontuario) {
        prontuario saved = service.save(prontuario);
        return ResponseEntity.created(URI.create("/api/prontuarios/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<prontuario> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<prontuario> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/animal/{animalId}")
    public List<prontuario> findByAnimal(@PathVariable Long animalId) {
        return service.findByAnimalId(animalId);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<prontuario> findByVeterinario(@PathVariable Long veterinarioId) {
        return service.findByVeterinarioId(veterinarioId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<prontuario> update(@PathVariable Long id, @RequestBody prontuario prontuario) {
        return service.findById(id)
                .map(existing -> {
                    prontuario.setId(id);
                    return ResponseEntity.ok(service.save(prontuario));
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
