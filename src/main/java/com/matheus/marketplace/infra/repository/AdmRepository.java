package com.matheus.marketplace.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matheus.marketplace.infra.entity.AdmEntity;

public interface AdmRepository extends MongoRepository<AdmEntity, String>{

}
