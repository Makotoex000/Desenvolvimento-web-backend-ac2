package com.example.petcaresolutions.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "animais")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cadatroAnimal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String especie;

	private String raca;

	private LocalDate dataNascimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("animais")
	private cadastroTutor tutor;

}
