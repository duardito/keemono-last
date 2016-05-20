package com.keemono.core.mysql.Repository.division;

import com.keemono.core.mysql.domain.division.Division;

import java.io.Serializable;
import java.util.List;

/**
 * Created by edu on 31/10/2015.
 */

public interface IDivisionRepository<M, S extends Serializable>{

    Division update(Division layout);

    Division findUUID(String uuid);

    Division save(Division layout);

    List<Division> findAll();
}
