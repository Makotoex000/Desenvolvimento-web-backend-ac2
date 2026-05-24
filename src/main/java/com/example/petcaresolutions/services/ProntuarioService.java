package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.prontuario;
import java.util.List;
import java.util.Optional;

public interface ProntuarioService {
    prontuario save(prontuario prontuario);
    Optional<prontuario> findById(Long id);
    List<prontuario> findAll();
    List<prontuario> findByAnimalId(Long animalId);
    List<prontuario> findByVeterinarioId(Long veterinarioId);
    void deleteById(Long id);
}
