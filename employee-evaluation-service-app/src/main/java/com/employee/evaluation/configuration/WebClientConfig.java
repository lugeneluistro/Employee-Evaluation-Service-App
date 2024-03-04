package com.employee.evaluation.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * The purpose of this configuration is to have template on calling external api using webclient
 * This is nothing to do with the employee evaluation service
 * */
@Configuration
public class WebClientConfig {

    @Value("${app.external.api.url.mock}")
    private String externalApiBaseUrl;

    @Bean
    public WebClient customWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(externalApiBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
