package com.matheus.marketplace.infra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.marketplace.infra.entity.ProdutoEntity;
import com.matheus.marketplace.infra.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    private ProdutoRepository produtoRepository;
	
	public ProdutoEntity create(ProdutoEntity Produto) {
		return produtoRepository.save(Produto);
	}
	
	public List<ProdutoEntity> findAll() {
		return produtoRepository.findAll();
	}

	public Optional<ProdutoEntity> findById(String id) {
		return produtoRepository.findById(id);
	}
	
	public ProdutoEntity update(String id, ProdutoEntity produtoAtualizado) {
		return produtoRepository.findById(id)
					.map(p -> {
						p.setNome(produtoAtualizado.getNome());
						p.setCodigo(produtoAtualizado.getCodigo());
						p.setDescricao(produtoAtualizado.getDescricao());
						p.setPreco(produtoAtualizado.getPreco());
						return produtoRepository.save(p);
					}).orElseThrow(() -> new RuntimeException("Usuário que deseja atualizar não foi encontrado."));
	}
	
	public void delete(String id) {
		produtoRepository.deleteById(id);
	}
}
