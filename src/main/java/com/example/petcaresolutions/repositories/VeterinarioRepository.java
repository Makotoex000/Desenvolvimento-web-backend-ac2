package com.example.petcaresolutions.repositories;

import com.example.petcaresolutions.models.cadastroVeterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VeterinarioRepository extends JpaRepository<cadastroVeterinario, Long> {
    List<cadastroVeterinario> findByEspecializacoesContaining(String especializacao);
}
