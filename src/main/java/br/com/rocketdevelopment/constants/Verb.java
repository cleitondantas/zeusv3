package br.com.rocketdevelopment.constants;

public enum Verb {
    GET("GET"),
    POST("POST"),
    PUT("PUT");
    private final String verbs;

    Verb(String url) {
        this.verbs = url;
    }

    public String get() {
        return verbs;
    }
}
