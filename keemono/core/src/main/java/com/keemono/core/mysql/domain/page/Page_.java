package com.keemono.core.mysql.domain.page;

import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by edu on 01/01/2016.
 */
@StaticMetamodel(Page.class)
public abstract class Page_ extends com.keemono.core.mysql.domain.AbstractDomain_{

    public static volatile SingularAttribute<Page, Layout> layout;
    public static volatile SingularAttribute<Page, User> creator;
}
