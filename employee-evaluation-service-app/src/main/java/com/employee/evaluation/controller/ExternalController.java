package com.employee.evaluation.controller;


import com.employee.evaluation.dto.response.external.ExternalUsers;
import com.employee.evaluation.integration.ExternalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping ("api/external/data/v1")
public class ExternalController {

    private final ExternalService externalService;

    @GetMapping("/users")
    public Flux<ExternalUsers> getExternalUsers () {
        return externalService.callExternalApi();
    }
}
