
package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertLed;
import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.exception.ServiceException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.Led;
import br.com.rocketdevelopment.model.BearerToken;

import java.util.Optional;

public class LedSerivce {
    private RequestService requestService;
    private ConvertLed convertLed;

    public LedSerivce(RequestService requestService, ConvertLed convertLed){
        this.requestService = requestService;
        this.convertLed = convertLed;
    }
    public Led getLedSettings(BearerToken token) throws ServiceException,ConvertException {
        String saidaJson = requestService.executeRequest(Verb.GET, EndPoints.LED, token, null)
                .orElseThrow(() -> new ServiceException("Request to LED endpoint failed or returned empty response"));
        DataValue<Led> dataLed = convertLed.convert(saidaJson)
                .orElseThrow(() -> new ConvertException("Failed to convert saidaJson to DataValue<Led>"));
        return dataLed.getData();
    }


    public void putLedSettings(BearerToken token, Led led) throws ConvertException, ServiceException {
        DataValue<Led> ledData = new DataValue<>();
        ledData.setData(led);

        String jsonString = convertLed.convertToJson(ledData)
                .orElseThrow(() -> new ConvertException("Failed to convert ledData to JSON"));

        requestService.executeRequest(Verb.PUT, EndPoints.LED, token, jsonString);
    }
}
