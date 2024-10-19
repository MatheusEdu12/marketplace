package com.matheus.marketplace.infra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.matheus.marketplace.infra.entity.AdmEntity;
import com.matheus.marketplace.infra.repository.AdmRepository;

public class AdmService {

	@Autowired
    private AdmRepository admRepository;
	
	public AdmEntity create(AdmEntity usuario) {
		return admRepository.save(usuario);
	}
	
	public List<AdmEntity> findAll() {
		return admRepository.findAll();
	}

	public Optional<AdmEntity> findById(String id) {
		return admRepository.findById(id);
	}
	
	public AdmEntity update(String id, AdmEntity admAtualizado) {
		return admRepository.findById(id)
					.map(a -> {
						a.setNome(admAtualizado.getNome());
						a.setEmail(admAtualizado.getEmail());
						a.setSenha(admAtualizado.getSenha());
						return admRepository.save(a);
					}).orElseThrow(() -> new RuntimeException("Administrador que deseja atualizar não foi encontrado."));
	}
	
	public void delete(String id) {
		admRepository.deleteById(id);
	}
}
