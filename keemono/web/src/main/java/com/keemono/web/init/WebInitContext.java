package com.keemono.web.init;

import com.keemono.security.WebSecurityConfiguration;
import com.keemono.web.WebConfiguration;
import com.keemono.web.filters.SimpleCORSFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.nio.charset.StandardCharsets;

/**
 * Created by edu on 18/04/2015.
 */
public class WebInitContext extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebConfiguration.class, WebSecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/" };
    }

    @Override
    protected Filter[] getServletFilters() {

        final SimpleCORSFilter simpleCORSFilter = new SimpleCORSFilter();
        final CharacterEncodingFilter characterEncodingFilter =
                new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] {simpleCORSFilter ,characterEncodingFilter };
    }
}
