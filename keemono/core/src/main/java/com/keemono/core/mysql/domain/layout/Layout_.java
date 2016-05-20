package com.keemono.core.mysql.domain.layout;

import com.keemono.core.mysql.domain.division.Division;
import com.keemono.core.mysql.domain.user.User;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Layout.class)
public abstract class Layout_ extends com.keemono.core.mysql.domain.AbstractDomain_ {

	public static volatile SetAttribute<Layout, Division> divisionList;
	public static volatile SingularAttribute<Layout, String> schema;
	public static volatile SingularAttribute<Layout, User> creator;



}

