package com.matheus.marketplace.infra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.marketplace.infra.entity.UsuarioEntity;
import com.matheus.marketplace.infra.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity create(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<UsuarioEntity> findById(String id) {
		return usuarioRepository.findById(id);
	}
	
	public UsuarioEntity update(String id, UsuarioEntity usuarioAtualizado) {
		return usuarioRepository.findById(id)
					.map(u -> {
						u.setNome(usuarioAtualizado.getNome());
						u.setEmail(usuarioAtualizado.getEmail());
						u.setSenha(usuarioAtualizado.getSenha());
						return usuarioRepository.save(u);
					}).orElseThrow(() -> new RuntimeException("Usuário que deseja atualizar não foi encontrado."));
	}
	
	public void delete(String id) {
		usuarioRepository.deleteById(id);
	}
	
}
