package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.vacina;
import java.util.List;
import java.util.Optional;

public interface VacinaService {
    vacina save(vacina vacina);
    Optional<vacina> findById(Long id);
    List<vacina> findAll();
    List<vacina> findByAnimalId(Long animalId);
    List<vacina> findByTutorId(Long tutorId);
    void deleteById(Long id);
}
