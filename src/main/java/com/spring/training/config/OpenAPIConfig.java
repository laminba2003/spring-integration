package com.spring.training.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi remoteService() {
        return createGroupedOpenApi("spring-rest");
    }
    private GroupedOpenApi createGroupedOpenApi(String name) {
        return GroupedOpenApi.builder()
                .pathsToMatch("/" + name + "/**")
                .group(name)
                .build();
    }

}
