package br.com.rocketdevelopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BearerToken {

    @JsonProperty("Token")
    private String token;

    public BearerToken() {
    }
    public BearerToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
