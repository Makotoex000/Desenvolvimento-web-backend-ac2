package com.example.petcaresolutions.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "veterinarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cadastroVeterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vet_especializacoes", joinColumns = @JoinColumn(name = "vet_id"))
    @Column(name = "especializacao")
    private Set<String> especializacoes = new HashSet<>();

    private String telefone;

}
