package com.lokesh.webclientconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Profile("default")
public class SwaggerConfig {
//    @Bean
//    public Docket configSwagger() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.lokesh.webclientconsumer.controller"))
//                .paths(regex("/controller.*"))
//                .build();
////                .apiInfo(apiInfo())
////                .useDefaultResponseMessages(false);
//    }

    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Microservices Webclient").description(
//                        "API documentation for service one reactive service with mongo database")
//                .termsOfServiceUrl("#")
//                .license("Apache License 2.0")
//                .licenseUrl("#").version("5.0.0")
//                .build();
        return null;
    }
}
