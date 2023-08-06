package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.exception.ServiceException;
import br.com.rocketdevelopment.model.BearerToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class RequestService {
    String domain;

    public RequestService(String domain){
        this.domain = domain;
    }


    public Optional<String> executeRequest(Verb verb, EndPoints endpoint, String jsonBodyStr) throws ServiceException {
        return executeRequest(verb, endpoint,null, jsonBodyStr);
    }


    public Optional<String> executeRequest(Verb verb,EndPoints endpoint, BearerToken token) throws ServiceException {
        return executeRequest(verb, endpoint, token, null);
    }

    public Optional<String> executeRequest(Verb verb, EndPoints endpoint, BearerToken token, String jsonBodyStr) throws ServiceException {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(domain + endpoint.getUrl());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            setupConnectionProperties(httpURLConnection, verb, token, jsonBodyStr);

            if (isValidResponse(httpURLConnection.getResponseCode())) {
                return convert(httpURLConnection.getInputStream());
            } else {
                throw new IOException("Error code: " + httpURLConnection.getResponseCode());
            }

        } catch (IOException e) {
            throw new ServiceException(e);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private void setupConnectionProperties(HttpURLConnection conn, Verb verb, BearerToken token, String jsonBodyStr) throws IOException {
        conn.setDoOutput(true);
        conn.setRequestMethod(verb.get());
        conn.setRequestProperty("Content-Type", "application/json");

        if (token != null) {
            conn.setRequestProperty("Authorization", "Bearer " + token.getToken());
        }

        if (jsonBodyStr != null) {
            conn.setRequestProperty("Content-Length", Integer.toString(jsonBodyStr.length()));
            try (OutputStream outputStream = conn.getOutputStream()) {
                outputStream.write(jsonBodyStr.getBytes());
                outputStream.flush();
            }
        }
    }

    private boolean isValidResponse(int responseCode) {
        return responseCode >= 200 && responseCode <= 300;
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
