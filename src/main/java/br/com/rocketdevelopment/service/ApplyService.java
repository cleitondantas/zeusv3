package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertSucess;
import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Sucess;
import br.com.rocketdevelopment.model.Token;

import java.util.Optional;

public class ApplyService {

    private RequestService requestService;
    private ConvertSucess convertSucess;

    public ApplyService(RequestService requestService, ConvertSucess convertSucess){
        this.requestService = requestService;
        this.convertSucess = convertSucess;
    }
    public Sucess applySettings(Token token) throws Exception {
        Optional<String> saidaJson = requestService.executeRequest(Verb.POST, EndPoints.APPLY, token, null);
        Optional<Data<Sucess>> dataSucess = convertSucess.convert(saidaJson.get());
        Data<Sucess> datasucess = dataSucess.isPresent() ? dataSucess.get() : null;
        Sucess sucess = datasucess.getData();
        return sucess;
    }

}
