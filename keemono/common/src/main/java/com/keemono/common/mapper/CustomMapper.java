package com.keemono.common.mapper;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by edu on 11/10/2015.
 */
@Component
public class CustomMapper extends ConfigurableMapper implements ApplicationContextAware {

    private MapperFactory factory;
    private ApplicationContext applicationContext;

    public CustomMapper(){
        super(false);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }


    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;
        addAllSpringBeans(applicationContext);
    }

    private void addAllSpringBeans(final ApplicationContext applicationContext) {

		Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
        mappers.values().stream().forEach(mapper -> addMapper(mapper));

        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
        converters.values().stream().forEach(converter -> addConverter(converter));

    }

    public void addConverter(Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

	public void addMapper(Mapper<?, ?> mapper) {
        ClassMapBuilder<?, ?> classMap = factory.classMap(mapper.getAType(), mapper.getBType())
                .customize((Mapper) mapper);
        if (mapper instanceof CustomBaseMapper) {
        	final CustomBaseMapper baseCustomMapper = (CustomBaseMapper) mapper;
            if (!baseCustomMapper.getExcludes().isEmpty()) {
                baseCustomMapper.getExcludes().forEach(field -> classMap.exclude((String) field));
            }

            if (!baseCustomMapper.getFields().isEmpty()) {
                baseCustomMapper.getFields().forEach((k, v) -> classMap.field((String) k, (String) v));
            }
        }

        classMap.byDefault()
                .register();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        //do not need to implement it
    }

}
