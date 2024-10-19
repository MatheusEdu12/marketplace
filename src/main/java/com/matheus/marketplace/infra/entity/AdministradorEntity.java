package com.matheus.marketplace.infra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;


@Document(collection = "administrador")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministradorEntity {

	@Id
	private String nome;
	private String email;
	private String senha;
	private String cpf;
}
