package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ConvertokenTest {
    String responseToken = "{\n" +
            "    \"data\": {\n" +
            "        \"Token\": \"7b73923f8d84e37cf02d83bb54df8da7\"\n" +
            "    }\n" +
            "}";

    @Test
    public void testConvertLogin() throws JsonProcessingException {
        ConvertToken convertToken = new ConvertToken(new ObjectMapper());
        Optional<Data<Token>> dataLed =  convertToken.convert(responseToken);
        Assert.assertTrue(dataLed.isPresent());
    }

    @Test
    public void testConvertLoginToJson() throws JsonProcessingException {
        ConvertToken convertToken = new ConvertToken(new ObjectMapper());
        Optional<Data<Token>> dataLed =  convertToken.convert(responseToken);
        Assert.assertTrue(dataLed.isPresent());
        Data<Token> tokenData = dataLed.get();
        Optional<String> json = convertToken.convertToJson(tokenData);
        Assert.assertTrue(json.isPresent());
    }

}
