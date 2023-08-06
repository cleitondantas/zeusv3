package br.com.rocketdevelopment.service.auth;

import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertToken;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.BearerToken;
import br.com.rocketdevelopment.model.UserPass;
import br.com.rocketdevelopment.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.Optional;

public class LoginService {
    private BearerToken token;
    private RequestService requestService;
    private ConvertToken convertToken;
    public LoginService(RequestService requestService, ConvertToken convertToken){
        this.requestService = requestService;
        this.convertToken = convertToken;
    }
    public BearerToken login(BasicConfig basicConfig) throws IOException {

        DataValue<UserPass> dataValue = new DataValue<>();
        dataValue.setData(basicConfig.getUserPass());
        ObjectMapper objectMapper = new ObjectMapper();
        String userpass = objectMapper.writeValueAsString(dataValue);
        Optional<String> strings = requestService.executeRequest(Verb.POST,EndPoints.LOGIN,userpass);
        Optional<DataValue<BearerToken>> convert = convertToken.convert(strings.get());
        token = convert.isPresent() ? convert.get().getData() : null;
        return token;
    }

    public BearerToken getToken() {
        return token;
    }


}
