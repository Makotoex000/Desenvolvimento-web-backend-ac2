package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.prontuario;
import com.example.petcaresolutions.repositories.ProntuarioRepository;
import com.example.petcaresolutions.services.ProntuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProntuarioServiceImpl implements ProntuarioService {

    private final ProntuarioRepository repo;

    public ProntuarioServiceImpl(ProntuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public prontuario save(prontuario prontuario) {
        return repo.save(prontuario);
    }

    @Override
    public Optional<prontuario> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<prontuario> findAll() {
        return repo.findAll();
    }

    @Override
    public List<prontuario> findByAnimalId(Long animalId) {
        return repo.findByAnimalId(animalId);
    }

    @Override
    public List<prontuario> findByVeterinarioId(Long veterinarioId) {
        return repo.findByVeterinarioId(veterinarioId);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
