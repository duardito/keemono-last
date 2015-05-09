package com.keemono.common.converter.base;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.MappingContextFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edu on 09/05/2015.
 */
public abstract class AbstractRequestConverter <REQUEST extends AbstractRequest, OBJECT extends AbstractDto>{
    private MapperFactory mapperFactory;
    private MappingContextFactory mappingContextFactory;

    private Class<REQUEST> dtoClass;
    private Class<OBJECT> entityClass;

    public AbstractRequestConverter() {
        super();
        mapperFactory = new DefaultMapperFactory.Builder().build();
        dtoClass = (Class<REQUEST>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entityClass = (Class<OBJECT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        mappingContextFactory = new MappingContext.Factory();
    }

    public REQUEST createDto(OBJECT object, String... options) {
        MappingContext mappingContext = mappingContextFactory.getContext();

        for (String option : options) {
            mappingContext.setProperty(option, option);
        }
        REQUEST result = getMapperFactory().getMapperFacade().map(object, dtoClass, mappingContext);
        return result;
    }

    public OBJECT createFromDto(REQUEST object) {
        OBJECT result = getMapperFactory().getMapperFacade().map(object, entityClass);
        return result;
    }

    protected MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
