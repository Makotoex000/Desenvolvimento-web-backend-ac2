package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VacinaRepository extends JpaRepository<vacina, Long> {
    List<vacina> findByAnimalId(Long animalId);
    List<vacina> findByAnimalTutorId(Long tutorId);
}
