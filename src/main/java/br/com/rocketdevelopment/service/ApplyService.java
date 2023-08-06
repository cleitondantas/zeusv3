package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertSucess;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.SystemSucess;
import br.com.rocketdevelopment.model.BearerToken;

import java.util.Optional;

public class ApplyService {

    private RequestService requestService;
    private ConvertSucess convertSucess;

    public ApplyService(RequestService requestService, ConvertSucess convertSucess){
        this.requestService = requestService;
        this.convertSucess = convertSucess;
    }
    public SystemSucess applySettings(BearerToken token) throws Exception {
        Optional<String> saidaJson = requestService.executeRequest(Verb.POST, EndPoints.APPLY, token, null);
        Optional<DataValue<SystemSucess>> dataSucess = convertSucess.convert(saidaJson.get());
        DataValue<SystemSucess> datasucess = dataSucess.isPresent() ? dataSucess.get() : null;
        return datasucess.getData();
    }

}
