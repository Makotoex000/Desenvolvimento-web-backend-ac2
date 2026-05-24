package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.cadastroTutor;
import java.util.List;
import java.util.Optional;

public interface TutorService {
    cadastroTutor save(cadastroTutor tutor);
    Optional<cadastroTutor> findById(Long id);
    Optional<cadastroTutor> findByCpf(String cpf);
    List<cadastroTutor> findAll();
}
