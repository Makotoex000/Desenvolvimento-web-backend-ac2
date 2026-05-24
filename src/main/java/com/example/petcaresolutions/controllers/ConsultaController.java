package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.consulta;
import com.example.petcaresolutions.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> schedule(@RequestBody consulta c) {
        try {
            consulta saved = service.schedule(c);
            return ResponseEntity.created(URI.create("/api/consultas/" + saved.getId())).body(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public List<consulta> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<consulta> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
