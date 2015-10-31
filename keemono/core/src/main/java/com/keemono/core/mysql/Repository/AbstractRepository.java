package com.keemono.core.mysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by edu on 31/10/2015.
 */
@NoRepositoryBean
public interface AbstractRepository <M, S extends Serializable> extends JpaRepository<M, S> {
}
