package com.employee.evaluation.services.integrations;


import com.employee.evaluation.dto.response.external.ExternalUsers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * The purpose of this class is to have template on calling external api using webclient
 * This is nothing to do with the employee evaluation service
 * */
@Service
@AllArgsConstructor
public class ExternalService {

    private final WebClient webClient;

    public Flux<ExternalUsers> callExternalApi() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/users").build())
                .retrieve()
                .bodyToFlux(ExternalUsers.class);
    }
}
