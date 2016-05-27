package com.keemono.core.mysql.domain.user;

import com.keemono.core.mysql.domain.layout.Layout;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(User.class)
public abstract class User_ extends com.keemono.core.mysql.domain.AbstractDomain_ {

	public static volatile ListAttribute<User, Layout> layout;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> email;

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Date> lastPasswordReset;
	public static volatile SingularAttribute<User, String> authorities;
}

