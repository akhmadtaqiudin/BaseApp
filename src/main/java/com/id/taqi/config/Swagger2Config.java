package com.id.taqi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Autowired
	private Environment env;
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.id.taqi.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(dataInfo());
    }
    private ApiInfo dataInfo() {
        return new ApiInfoBuilder().title(env.getProperty("APP_NAME"))
                .description(env.getProperty("DESCRIPTION"))
                .version(env.getProperty("VERSION"))
                .build();
    }
}
