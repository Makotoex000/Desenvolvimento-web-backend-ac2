package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.cadatroAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<cadatroAnimal, Long> {
    List<cadatroAnimal> findByEspecie(String especie);
}
