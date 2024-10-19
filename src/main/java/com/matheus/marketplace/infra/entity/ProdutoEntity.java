package com.matheus.marketplace.infra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "produto")
public class ProdutoEntity {

	@Id
	private String codigo;
	private String nome;
	private Double preco;
	private String descricao;
}
