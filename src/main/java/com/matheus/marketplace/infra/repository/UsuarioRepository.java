package com.matheus.marketplace.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.matheus.marketplace.infra.entity.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

}
