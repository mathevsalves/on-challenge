package com.matheus.onchallenge.client;

import com.matheus.onchallenge.dto.CepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepClient {
    private final WebClient webClient;

    public CepClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081").build();
    }

    public CepResponse findCep(String cep) {
        return webClient.get()
                .uri("/cep/{cep}", cep)
                .retrieve()
                .bodyToMono(CepResponse.class)
                .block();
    }
}
