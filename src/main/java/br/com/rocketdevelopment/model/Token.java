package br.com.rocketdevelopment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {

    @JsonProperty("Token")
    private String token;

    public Token() {
    }
    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
