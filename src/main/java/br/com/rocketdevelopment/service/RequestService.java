package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.model.Token;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class RequestService {
    String domain;

    public RequestService(String domain){
        this.domain = domain;
    }


    public Optional<String> executeRequest(Verb verb, EndPoints endpoint, String jsonBodyStr) throws IOException {
        return executeRequest(verb, endpoint,null, jsonBodyStr);
    }


    public Optional<String> executeRequest(Verb verb,EndPoints endpoint, Token token) throws IOException {
        return executeRequest(verb, endpoint, token, null);
    }

    public Optional<String> executeRequest(Verb verb, EndPoints endpoint, Token token, String jsonBodyStr) throws IOException {
        URL url = new URL(domain+endpoint.getUrl());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod(verb.get());
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        if(token != null){
            httpURLConnection.setRequestProperty("Authorization", "Bearer " + token.getToken());
        }
        if(jsonBodyStr != null){
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(jsonBodyStr.length()));
            try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
                outputStream.write(jsonBodyStr.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
           return convert(httpURLConnection.getInputStream());
        }else{
            throw new IOException("Error code: " + httpURLConnection.getResponseCode());
        }
    }
    public static Optional<String> convert(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultStringBuilder.append(line).append('\n');
            }
        }
        return Optional.of(resultStringBuilder.toString());
    }

}
