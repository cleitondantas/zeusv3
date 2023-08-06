package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertSucess;
import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.exception.ServiceException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.SystemSucess;
import br.com.rocketdevelopment.model.BearerToken;

import java.io.IOException;
import java.util.Optional;

public class ApplyService {

    private final RequestService requestService;
    private final ConvertSucess convertSucess;

    public ApplyService(RequestService requestService, ConvertSucess convertSucess){
        this.requestService = requestService;
        this.convertSucess = convertSucess;
    }
    public SystemSucess applySettings(BearerToken token) throws ServiceException, ConvertException {
        Optional<String> saidaJson =  requestService.executeRequest(Verb.POST, EndPoints.APPLY, token, null);
        if (!saidaJson.isPresent()) {
            throw new ServiceException("Saída JSON está vazia.");
        }
        Optional<DataValue<SystemSucess>> dataSucess = convertSucess.convert(saidaJson.get());
        DataValue<SystemSucess> datasucess = dataSucess.orElseThrow(() -> new ConvertException("Conversão não foi bem-sucedida."));

        return datasucess.getData();
    }

}
