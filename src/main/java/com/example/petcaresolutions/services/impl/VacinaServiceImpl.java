package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.vacina;
import com.example.petcaresolutions.repositories.VacinaRepository;
import com.example.petcaresolutions.services.VacinaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VacinaServiceImpl implements VacinaService {

    private final VacinaRepository repo;

    public VacinaServiceImpl(VacinaRepository repo) {
        this.repo = repo;
    }

    @Override
    public vacina save(vacina vacina) {
        return repo.save(vacina);
    }

    @Override
    public Optional<vacina> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<vacina> findAll() {
        return repo.findAll();
    }

    @Override
    public List<vacina> findByAnimalId(Long animalId) {
        return repo.findByAnimalId(animalId);
    }

    @Override
    public List<vacina> findByTutorId(Long tutorId) {
        return repo.findByAnimalTutorId(tutorId);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
