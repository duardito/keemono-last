package com.keemono.common.request.converter.base;

import com.keemono.common.dto.converter.base.AbstractDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.MappingContextFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edu on 25/04/2015.
 */
public abstract class AbstractResponseConverter <RESPONSE extends AbstractResponse, OBJECT extends AbstractDto>{

    private MapperFactory mapperFactory;
    private MappingContextFactory mappingContextFactory;

    private Class<RESPONSE> dtoClass;
    private Class<OBJECT> entityClass;

    public AbstractResponseConverter() {
        super();
        mapperFactory = new DefaultMapperFactory.Builder().build();
        dtoClass = (Class<RESPONSE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entityClass = (Class<OBJECT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        mappingContextFactory = new MappingContext.Factory();
    }

    public RESPONSE createDto(OBJECT object, String... options) {
        MappingContext mappingContext = mappingContextFactory.getContext();

        for (String option : options) {
            mappingContext.setProperty(option, option);
        }
        RESPONSE result = getMapperFactory().getMapperFacade().map(object, dtoClass, mappingContext);
        return result;
    }

    public OBJECT createFromDto(RESPONSE object) {
        OBJECT result = getMapperFactory().getMapperFacade().map(object, entityClass);
        return result;
    }

    protected MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
