
package br.com.rocketdevelopment.service;

import br.com.rocketdevelopment.config.BasicConfig;
import br.com.rocketdevelopment.constants.EndPoints;
import br.com.rocketdevelopment.constants.Verb;
import br.com.rocketdevelopment.converter.ConvertLed;
import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Led;
import br.com.rocketdevelopment.model.Token;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Optional;

public class LedSerivce {
    private RequestService requestService;
    private ConvertLed convertLed;

    public LedSerivce(RequestService requestService, ConvertLed convertLed){
        this.requestService = requestService;
        this.convertLed = convertLed;
    }
    public Led getLedSettings(Token token) throws Exception {
        Optional<String> saidaJson = requestService.executeRequest(Verb.GET, EndPoints.LED, token, null);
        Optional<Data<Led>> dataLed = convertLed.convert(saidaJson.get());
        Data<Led> dataled = dataLed.isPresent() ? dataLed.get() : null;
        Led led = dataled.getData();
        return led;
    }

    public void putLedSettings(Token token,Led led) throws Exception {
        Data<Led> ledData = new Data<>();
        ledData.setData(led);
        Optional<String> jsonLed = convertLed.convertToJson(ledData);
        requestService.executeRequest(Verb.PUT, EndPoints.LED, token, jsonLed.get());
    }
}
