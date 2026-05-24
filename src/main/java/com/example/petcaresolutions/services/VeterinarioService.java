package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.cadastroVeterinario;
import java.util.List;
import java.util.Optional;

public interface VeterinarioService {
    cadastroVeterinario save(cadastroVeterinario vet);
    Optional<cadastroVeterinario> findById(Long id);
    List<cadastroVeterinario> findByEspecializacao(String especializacao);
    List<cadastroVeterinario> findAll();
}
