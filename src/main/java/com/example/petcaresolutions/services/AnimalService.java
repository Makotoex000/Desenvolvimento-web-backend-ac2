package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.cadatroAnimal;
import java.util.List;
import java.util.Optional;

public interface AnimalService {
    cadatroAnimal save(cadatroAnimal animal);
    Optional<cadatroAnimal> findById(Long id);
    List<cadatroAnimal> findByEspecie(String especie);
    List<cadatroAnimal> findAll();
}
