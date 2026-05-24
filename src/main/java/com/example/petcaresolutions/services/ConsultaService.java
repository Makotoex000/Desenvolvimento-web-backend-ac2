package com.example.petcaresolutions.services;

import com.example.petcaresolutions.models.consulta;
import java.util.List;
import java.util.Optional;

public interface ConsultaService {
    consulta schedule(consulta c) throws IllegalArgumentException;
    Optional<consulta> findById(Long id);
    List<consulta> findAll();
}
