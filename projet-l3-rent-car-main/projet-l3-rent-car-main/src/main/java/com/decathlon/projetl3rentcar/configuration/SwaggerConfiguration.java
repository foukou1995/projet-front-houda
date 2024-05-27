package com.decathlon.projetl3rentcar.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
@RequiredArgsConstructor
public class SwaggerConfiguration {

    @Value("${app.projet-l3-rent-car-prefix-url}")
    private String rentCarPrefixUrl;

    private final ObjectMapper objectMapper;

    @Bean
    public OpenAPI openAPI() {
        // With this hack we inject into Swagger the same object mapper used by Spring (spring.jackson.property-naming-strategy)
        ModelConverters.getInstance().addConverter(new ModelResolver(objectMapper));
        return new OpenAPI()
                .info(new Info()
                        .title("Rent car")
                        .description("API dedicated to rent car")
                        .version("v1")
                        .contact(new Contact().name("L3 IT")
                                .email("nourelhoudaoukoukes@gmail.com")))
                .addServersItem(new Server().url(rentCarPrefixUrl));
    }

    @Bean
    public GroupedOpenApi allApis() {
        return GroupedOpenApi.builder().group("internal").pathsToMatch("/**").build();
    }
}
