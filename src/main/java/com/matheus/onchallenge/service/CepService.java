package com.matheus.onchallenge.service;

import com.matheus.onchallenge.client.CepClient;
import com.matheus.onchallenge.dto.CepResponse;
import com.matheus.onchallenge.exception.CepNotFoundException;
import com.matheus.onchallenge.model.RequestRegister;
import com.matheus.onchallenge.repository.RequestRegisterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CepService {

    private final CepClient cepClient;
    private final RequestRegisterRepository requestRegisterRepository;

    CepService(CepClient cepClient, RequestRegisterRepository requestRegisterRepository) {
        this.cepClient = cepClient;
        this.requestRegisterRepository = requestRegisterRepository;
    }

    public CepResponse findAddressByCep(String cep) {
        CepResponse response = cepClient.findCep(cep);

        if (response == null || response.getCep() == null) {
            throw new CepNotFoundException("CEP não encontrado: " + cep);
        }

        RequestRegister requestRegister = new RequestRegister();

        requestRegister.setCep(response.getCep());
        requestRegister.setResponse(response.toString());
        requestRegister.setTimestamp(LocalDateTime.now());

        requestRegisterRepository.save(requestRegister);

        return response;
    }
}
