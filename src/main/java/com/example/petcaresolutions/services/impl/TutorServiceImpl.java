package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.cadastroTutor;
import com.example.petcaresolutions.repositories.TutorRepository;
import com.example.petcaresolutions.services.TutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    private final TutorRepository repo;

    public TutorServiceImpl(TutorRepository repo) {
        this.repo = repo;
    }

    @Override
    public cadastroTutor save(cadastroTutor tutor) {
        return repo.save(tutor);
    }

    @Override
    public Optional<cadastroTutor> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<cadastroTutor> findByCpf(String cpf) {
        return repo.findByCpf(cpf);
    }

    @Override
    public List<cadastroTutor> findAll() {
        return repo.findAll();
    }
}
