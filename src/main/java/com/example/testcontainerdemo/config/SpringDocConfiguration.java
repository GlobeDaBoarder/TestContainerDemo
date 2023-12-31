package com.example.testcontainerdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean(name = "org.openapitools.configuration.SpringDocConfiguration.apiInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Pet API")
                                .description("Pet API")
                                .contact(
                                        new Contact()
                                                .name("Gleb")
                                                .email("glebivashyn@gmail.com")
                                )
                                .license(
                                        new License()
                                                .name("Open Source")
                                                .url("http://unlicense.org")
                                )
                                .version("1.0.0")
                )
        ;
    }
}
