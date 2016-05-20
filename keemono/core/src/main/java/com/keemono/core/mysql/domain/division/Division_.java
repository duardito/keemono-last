package com.keemono.core.mysql.domain.division;

import com.keemono.core.mysql.domain.content.Content;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by edu on 20/05/2016.
 */
@StaticMetamodel(Division.class)
public abstract class Division_ extends com.keemono.core.mysql.domain.AbstractDomain_ {

    public static volatile SingularAttribute<Division, Content> content;
    public static volatile SingularAttribute<Division, String> schema;
}
