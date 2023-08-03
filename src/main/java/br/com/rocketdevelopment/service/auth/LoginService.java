package br.com.rocketdevelopment.service.auth;

import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Token;
import br.com.rocketdevelopment.model.UserPass;
import br.com.rocketdevelopment.service.RequestService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.Optional;

public class LoginService {
    private Token token;
    private RequestService requestService;
    private ConvertToken convertToken;
    public LoginService(RequestService requestService, ConvertToken convertToken){
        this.requestService = requestService;
        this.convertToken = convertToken;
    }
    public Token login(BasicConfig basicConfig) throws IOException {

        Data<UserPass> data = new Data<>();
        data.setData(basicConfig.getUserPass());
        ObjectMapper objectMapper = new ObjectMapper();
        String userpass = objectMapper.writeValueAsString(data);
        Optional<String> strings = requestService.executeRequest(Verb.POST,EndPoints.LOGIN,userpass);
        Optional<Data<Token>> convert = convertToken.convert(strings.get());
        token = convert.isPresent() ? convert.get().getData() : null;
        return token;
    }

    public Token getToken() {
        return token;
    }


}
