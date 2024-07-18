package com.shyam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${application.graphql.serverUrl}")
    private String serverUrl;
    
    @Bean
    HttpGraphQlClient httpGraphQlClient() {
        WebClient webClient = WebClient
                                .builder()
                                .baseUrl(serverUrl)
                                .build();

        return HttpGraphQlClient
                .builder(webClient)
                .build();
    }
}