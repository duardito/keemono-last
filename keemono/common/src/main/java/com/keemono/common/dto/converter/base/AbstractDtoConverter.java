package com.keemono.common.dto.converter.base;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.MappingContextFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edu on 25/4/15.
 */
@Component
public abstract class AbstractDtoConverter<DTO extends AbstractDto, OBJECT>{

    private MapperFactory mapperFactory;
    private MappingContextFactory mappingContextFactory;

    private Class<DTO> dtoClass;
    private Class<OBJECT> entityClass;

    public AbstractDtoConverter() {
        super();
        mapperFactory = new DefaultMapperFactory.Builder().build();
        dtoClass = (Class<DTO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entityClass = (Class<OBJECT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        mappingContextFactory = new MappingContext.Factory();
    }

    public DTO createDto(OBJECT object, String... options) {
        MappingContext mappingContext = mappingContextFactory.getContext();

        for (String option : options) {
            mappingContext.setProperty(option, option);
        }
        DTO result = getMapperFactory().getMapperFacade().map(object, dtoClass, mappingContext);
        return result;
    }

    public OBJECT createFromDto(DTO object) {
        OBJECT result = getMapperFactory().getMapperFacade().map(object, entityClass);
        return result;
    }

    protected MapperFactory getMapperFactory() {
        return mapperFactory;
    }
}
