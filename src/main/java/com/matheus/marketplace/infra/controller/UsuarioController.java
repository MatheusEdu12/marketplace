package com.matheus.marketplace.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.marketplace.infra.entity.UsuarioEntity;
import com.matheus.marketplace.infra.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioEntity> create(@RequestBody UsuarioEntity usuario) {
		UsuarioEntity novoUsuario = usuarioService.create(usuario);
		return ResponseEntity.ok(novoUsuario);
	}
	
	@GetMapping
	public List<UsuarioEntity> findAll() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<UsuarioEntity> findById(@PathVariable String id) {
		return usuarioService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioEntity> update(@PathVariable String id, @RequestBody UsuarioEntity usuario) {
		return ResponseEntity.ok(
				usuarioService.update(id, usuario)
				);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
