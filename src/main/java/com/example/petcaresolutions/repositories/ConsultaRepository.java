package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.consulta;
import com.example.petcaresolutions.models.cadastroVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<consulta, Long> {
    boolean existsByVeterinarioAndDataHora(cadastroVeterinario veterinario, LocalDateTime dataHora);
}
