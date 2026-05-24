package com.example.petcaresolutions.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prontuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private cadatroAnimal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinario_id")
    private cadastroVeterinario veterinario;

    private LocalDateTime dataAtendimento;

    @Column(length = 2000)
    private String observacoes;

}
