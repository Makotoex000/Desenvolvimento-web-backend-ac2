package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProntuarioRepository extends JpaRepository<prontuario, Long> {
    List<prontuario> findByAnimalId(Long animalId);
    List<prontuario> findByVeterinarioId(Long veterinarioId);
}
