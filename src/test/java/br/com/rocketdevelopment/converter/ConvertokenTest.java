package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.exception.ServiceException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.BearerToken;
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
    public void testConvertLogin() throws ConvertException {
        ConvertToken convertToken = new ConvertToken(new ObjectMapper());
        Optional<DataValue<BearerToken>> dataLed =  convertToken.convert(responseToken);
        Assert.assertTrue(dataLed.isPresent());
    }

    @Test
    public void testConvertLoginToJson() throws ConvertException {
        ConvertToken convertToken = new ConvertToken(new ObjectMapper());
        Optional<DataValue<BearerToken>> dataLed =  convertToken.convert(responseToken);
        Assert.assertTrue(dataLed.isPresent());
        DataValue<BearerToken> tokenData = dataLed.get();
        Optional<String> json = convertToken.convertToJson(tokenData);
        Assert.assertTrue(json.isPresent());
    }

}
