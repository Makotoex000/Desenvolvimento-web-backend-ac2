package com.example.petcaresolutions.services.impl;

import com.example.petcaresolutions.models.cadastroVeterinario;
import com.example.petcaresolutions.repositories.VeterinarioRepository;
import com.example.petcaresolutions.services.VeterinarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repo;

    public VeterinarioServiceImpl(VeterinarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public cadastroVeterinario save(cadastroVeterinario vet) {
        return repo.save(vet);
    }

    @Override
    public Optional<cadastroVeterinario> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<cadastroVeterinario> findByEspecializacao(String especializacao) {
        return repo.findByEspecializacoesContaining(especializacao);
    }

    @Override
    public List<cadastroVeterinario> findAll() {
        return repo.findAll();
    }
}
