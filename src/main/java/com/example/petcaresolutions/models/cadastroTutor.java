package com.example.petcaresolutions.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tutores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class cadastroTutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Column(unique = true, nullable = false)
	private String cpf;

	private String telefone;

	private String endereco;

	@OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private List<cadatroAnimal> animais = new ArrayList<>();

}
