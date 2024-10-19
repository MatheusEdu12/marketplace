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

import com.matheus.marketplace.infra.entity.AdmEntity;
import com.matheus.marketplace.infra.service.AdmService;

@RestController
@RequestMapping("/api/administrador")
public class AdmController {
	
	@Autowired
	private AdmService admService;

	@PostMapping
	public ResponseEntity<AdmEntity> create(@RequestBody AdmEntity adm) {
		AdmEntity novoadm = admService.create(adm);
		return ResponseEntity.ok(novoadm);
	}
	
	@GetMapping
	public List<AdmEntity> findAll() {
		return admService.findAll();
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<AdmEntity> findById(@PathVariable String id) {
		return admService.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdmEntity> update(@PathVariable String id, @RequestBody AdmEntity adm) {
		return ResponseEntity.ok(
				admService.update(id, adm)
				);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		admService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
