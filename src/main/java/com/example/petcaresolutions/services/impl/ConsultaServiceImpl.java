package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.consulta;
import com.example.petcaresolutions.models.cadatroAnimal;
import com.example.petcaresolutions.models.cadastroVeterinario;
import com.example.petcaresolutions.repositories.AnimalRepository;
import com.example.petcaresolutions.repositories.ConsultaRepository;
import com.example.petcaresolutions.repositories.VeterinarioRepository;
import com.example.petcaresolutions.services.ConsultaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository repo;
    private final AnimalRepository animalRepo;
    private final VeterinarioRepository vetRepo;

    public ConsultaServiceImpl(ConsultaRepository repo, AnimalRepository animalRepo, VeterinarioRepository vetRepo) {
        this.repo = repo;
        this.animalRepo = animalRepo;
        this.vetRepo = vetRepo;
    }

    @Override
    public consulta schedule(consulta c) throws IllegalArgumentException {
        if (c.getVeterinario() == null || c.getVeterinario().getId() == null) {
            throw new IllegalArgumentException("Veterinario obrigatório");
        }

        if (c.getAnimal() == null || c.getAnimal().getId() == null) {
            throw new IllegalArgumentException("Animal obrigatório");
        }

        Long vetId = c.getVeterinario().getId();
        Long animalId = c.getAnimal().getId();

        cadastroVeterinario vet = vetRepo.findById(vetId).orElseThrow(() -> new IllegalArgumentException("Veterinario não encontrado"));
        cadatroAnimal animal = animalRepo.findById(animalId).orElseThrow(() -> new IllegalArgumentException("Animal não encontrado"));

        String especie = animal.getEspecie();
        if (especie == null) {
            throw new IllegalArgumentException("Espécie do animal é obrigatória");
        }
        boolean especializado = vet.getEspecializacoes() != null && vet.getEspecializacoes().stream()
                .anyMatch(s -> s != null && s.trim().equalsIgnoreCase(especie.trim()));
        if (!especializado) {
            throw new IllegalArgumentException("Veterinario não é especializado na espécie do animal");
        }

        boolean ocupado = repo.existsByVeterinarioAndDataHora(vet, c.getDataHora());
        if (ocupado) {
            throw new IllegalArgumentException("Veterinario já possui atendimento neste horário");
        }

        c.setVeterinario(vet);
        c.setAnimal(animal);

        return repo.save(c);
    }

    @Override
    public Optional<consulta> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<consulta> findAll() {
        return repo.findAll();
    }
}
