package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.cadastroTutor;
import com.example.petcaresolutions.services.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<cadastroTutor> create(@RequestBody cadastroTutor tutor) {
        cadastroTutor saved = service.save(tutor);
        return ResponseEntity.created(URI.create("/api/tutores/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<cadastroTutor> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<cadastroTutor> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
