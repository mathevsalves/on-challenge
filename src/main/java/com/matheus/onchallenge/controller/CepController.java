package com.matheus.onchallenge.controller;

import com.matheus.onchallenge.dto.CepResponse;
import com.matheus.onchallenge.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponse> findAddressByCep(@PathVariable String cep) {
        CepResponse cepResponse = cepService.findAddressByCep(cep);
        if (cepResponse == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cepResponse);
    }

}
