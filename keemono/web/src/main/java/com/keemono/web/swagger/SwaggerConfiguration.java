package com.keemono.web.swagger;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by edu on 06/06/2015.
 */
@PropertySource("classpath:config/init.properties")
@Configuration
@EnableSwagger
public class SwaggerConfiguration {

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
                apiInfo()).includePatterns("/.*");
    }

/*
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
        swaggerSpringMvcPlugin.apiInfo(apiInfo());
        swaggerSpringMvcPlugin.includePatterns("/*");
        swaggerSpringMvcPlugin.apiListingReferenceOrdering(new ResourceListingPositionalOrdering());
        swaggerSpringMvcPlugin.globalResponseMessage(RequestMethod.GET, new ArrayList<ResponseMessage>());
        swaggerSpringMvcPlugin.globalResponseMessage(RequestMethod.POST, new ArrayList<ResponseMessage>());
        swaggerSpringMvcPlugin.globalResponseMessage(RequestMethod.PUT, new ArrayList<ResponseMessage>());
        swaggerSpringMvcPlugin.globalResponseMessage(RequestMethod.DELETE, new ArrayList<ResponseMessage>());

        return swaggerSpringMvcPlugin;
    }
*/
    private ApiInfo apiInfo() {
        return new ApiInfo("Keemono API", "Keemono API documentation!", "", "admin@keemono.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html");
    }
}
