package br.com.rocketdevelopment.constants;

public enum Verb {
    GET("GET"),
    POST("POST"),
    PUT("PUT");
    private final String VERB;

    Verb(String url) {
        this.VERB = url;
    }

    public String get() {
        return VERB;
    }
}
