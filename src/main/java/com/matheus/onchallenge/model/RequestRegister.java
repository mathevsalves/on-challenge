package com.matheus.onchallenge.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
public class RequestRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String response;

    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "RequestRegister{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", response='" + response + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
