package br.com.rocketdevelopment.service.auth;

import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.converter.ConvertUserPass;
import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.exception.ServiceException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.BearerToken;
import br.com.rocketdevelopment.model.UserPass;
import br.com.rocketdevelopment.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.Optional;

public class LoginService {
    private BearerToken token;
    private final RequestService requestService;
    private final ConvertToken convertToken;
    private final ConvertUserPass convertUserPass;
    public LoginService(RequestService requestService, ConvertToken convertToken, ConvertUserPass convertUserPass) {
        this.requestService = requestService;
        this.convertToken = convertToken;
        this.convertUserPass = convertUserPass;
    }
    public BearerToken login(BasicConfig basicConfig) throws ConvertException, ServiceException {
        DataValue<UserPass> userPass = new DataValue<>();
        userPass.setData(basicConfig.getUserPass());

        String jsonpass = convertUserPass.convertToJson(userPass)
                .orElseThrow(() -> new ConvertException("Failed to convert userPass to JSON"));

        String responseString = requestService.executeRequest(Verb.POST, EndPoints.LOGIN, jsonpass)
                .orElseThrow(() -> new ServiceException("Request to LOGIN endpoint failed or returned empty response"));

        DataValue<BearerToken> bearerTokenDataValue = convertToken.convert(responseString)
                .orElseThrow(() -> new ConvertException("Failed to convert response to BearerToken"));

        return bearerTokenDataValue.getData();
    }

    public BearerToken getToken() {
        return token;
    }


}
