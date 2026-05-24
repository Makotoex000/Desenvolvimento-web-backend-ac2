package com.example.petcaresolutions.controllers;

import com.example.petcaresolutions.models.cadastroVeterinario;
import com.example.petcaresolutions.services.VeterinarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioService service;

    public VeterinarioController(VeterinarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<cadastroVeterinario> create(@RequestBody cadastroVeterinario vet) {
        cadastroVeterinario saved = service.save(vet);
        return ResponseEntity.created(URI.create("/api/veterinarios/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<cadastroVeterinario> list() {
        return service.findAll();
    }

    @GetMapping("/especialidade/{esp}")
    public List<cadastroVeterinario> byEspecialidade(@PathVariable("esp") String esp) {
        return service.findByEspecializacao(esp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<cadastroVeterinario> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
