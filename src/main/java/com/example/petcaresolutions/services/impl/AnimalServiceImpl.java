package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.cadatroAnimal;
import com.example.petcaresolutions.repositories.AnimalRepository;
import com.example.petcaresolutions.services.AnimalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repo;

    public AnimalServiceImpl(AnimalRepository repo) {
        this.repo = repo;
    }

    @Override
    public cadatroAnimal save(cadatroAnimal animal) {
        return repo.save(animal);
    }

    @Override
    public Optional<cadatroAnimal> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<cadatroAnimal> findByEspecie(String especie) {
        return repo.findByEspecie(especie);
    }

    @Override
    public List<cadatroAnimal> findAll() {
        return repo.findAll();
    }
}
