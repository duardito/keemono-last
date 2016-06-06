package com.keemono.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by edu on 06/06/2015.
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    private Docket baseDocket = new Docket(DocumentationType.SWAGGER_2)
            .pathMapping("/")
            .globalResponseMessage(RequestMethod.GET, getMessageResponse())
            .globalResponseMessage(RequestMethod.POST, postMessageResponse())
            .globalResponseMessage(RequestMethod.PUT, putMessageResponse())
            .globalResponseMessage(RequestMethod.DELETE, deleteMessageResponse())
            .useDefaultResponseMessages(false);

    protected ArrayList<ResponseMessage> deleteMessageResponse() {
        return newArrayList(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build(),
                new ResponseMessageBuilder()
                        .code(204)
                        .message("No Content")
                        .build());
    }

    protected ArrayList<ResponseMessage> postMessageResponse() {
        return newArrayList(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build(),
                new ResponseMessageBuilder()
                        .code(201)
                        .message("Created")
                        .build());
    }

    protected ArrayList<ResponseMessage> getMessageResponse() {
        return newArrayList(new ResponseMessageBuilder()
                .code(200)
                .message("OK")
                .build());
    }

    protected ArrayList<ResponseMessage> putMessageResponse() {
        return newArrayList(new ResponseMessageBuilder()
                        .code(200)
                        .message("OK")
                        .build(),
                new ResponseMessageBuilder()
                        .code(204)
                        .message("No Content")
                        .build());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    /*
    @Bean
    public Docket api() {
        return baseDocket.select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().contact("admin@keemono.com")
                .description("keemono  API server list.")
                .title("Keemono API server")
                .version("1.0")
                .license("Legal Notice and Privacy Policy")
                .licenseUrl("https://www.keemono.com")
                .termsOfServiceUrl("https://www.keemono.com")
                .build();
    }

}
