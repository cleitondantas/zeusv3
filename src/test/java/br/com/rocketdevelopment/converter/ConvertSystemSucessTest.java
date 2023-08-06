package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.SystemSucess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ConvertSystemSucessTest {
    private String responseSucess = "{\n" +
            "    \"data\": {\n" +
            "        \"success\": true,\n" +
            "        \"sucess\": true,\n" +
            "        \"config_hash\": \"a6fe081f041bfbd349655e940c82d757\"\n" +
            "    }\n" +
            "}";

    
    @Test
    public void testConvert() throws ConvertException {
        ConvertSucess convertSucess = new ConvertSucess(new ObjectMapper());
        DataValue<SystemSucess> sucessDataValue = convertSucess.convert(responseSucess)
                .orElseThrow(() -> new ConvertException("Failed to convert responseSucess"));
        Assert.assertTrue(sucessDataValue.getData().isSucess());
    }

    @Test
    public void testConvertToJson() throws ConvertException {
        ConvertSucess convertSucess = new ConvertSucess(new ObjectMapper());
        DataValue<SystemSucess> sucessDataValue = convertSucess.convert(responseSucess)
                .orElseThrow(() -> new ConvertException("Failed to convert responseSucess"));
        Assert.assertTrue(sucessDataValue.getData().isSucess());
        String jsonString = convertSucess.convertToJson(sucessDataValue)
                .orElseThrow(() -> new ConvertException("Failed to convert sucessDataValue to JSON"));
        Assert.assertTrue(jsonString.contains("a6fe081f041bfbd349655e940c82d757"));
    }
}
