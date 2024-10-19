package com.matheus.marketplace.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matheus.marketplace.infra.entity.ProdutoEntity;

public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {

}
