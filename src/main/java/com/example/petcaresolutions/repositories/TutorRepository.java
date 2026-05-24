package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.cadastroTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TutorRepository extends JpaRepository<cadastroTutor, Long> {
    Optional<cadastroTutor> findByCpf(String cpf);
}
