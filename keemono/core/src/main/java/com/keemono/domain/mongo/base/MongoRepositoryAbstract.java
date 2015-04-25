package com.keemono.domain.mongo.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by edu on 25/4/15.
 */
@NoRepositoryBean
public interface MongoRepositoryAbstract<M, S extends Serializable> extends MongoRepository<M, S> {
}
