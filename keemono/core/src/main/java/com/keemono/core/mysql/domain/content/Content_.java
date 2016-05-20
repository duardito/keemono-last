package com.keemono.core.mysql.domain.content;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by edu on 20/05/2016.
 */
@StaticMetamodel(Content.class)
public abstract class Content_  extends com.keemono.core.mysql.domain.AbstractDomain_ {

    public static volatile SingularAttribute<Content, String> content;

}
