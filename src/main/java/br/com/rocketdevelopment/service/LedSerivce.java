
package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertLed;
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
    public Led getLedSettings(BearerToken token) throws Exception {
        Optional<String> saidaJson = requestService.executeRequest(Verb.GET, EndPoints.LED, token, null);
        Optional<DataValue<Led>> dataLed = convertLed.convert(saidaJson.get());
        DataValue<Led> dataled = dataLed.isPresent() ? dataLed.get() : null;
        Led led = dataled.getData();
        return led;
    }

    public void putLedSettings(BearerToken token, Led led) throws Exception {
        DataValue<Led> ledData = new DataValue<>();
        ledData.setData(led);
        Optional<String> jsonLed = convertLed.convertToJson(ledData);
        requestService.executeRequest(Verb.PUT, EndPoints.LED, token, jsonLed.get());
    }
}
