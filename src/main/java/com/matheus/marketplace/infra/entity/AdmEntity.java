package com.matheus.marketplace.infra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "administrador")
public class AdmEntity {

	@Id
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	
	public AdmEntity(String nome, String email, String senha, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
