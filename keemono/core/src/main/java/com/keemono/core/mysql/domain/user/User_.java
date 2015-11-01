package com.keemono.core.mysql.domain.user;

import com.keemono.core.mysql.domain.layout.Layout;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.keemono.core.mysql.domain.AbstractDomain_ {

	public static volatile ListAttribute<User, Layout> layout;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> email;

}

