package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Sucess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ConvertSucessTest {
    private String responseSucess = "{\n" +
            "    \"data\": {\n" +
            "        \"success\": true,\n" +
            "        \"sucess\": true,\n" +
            "        \"config_hash\": \"a6fe081f041bfbd349655e940c82d757\"\n" +
            "    }\n" +
            "}";

    
    @Test
    public void testConvert() throws JsonProcessingException {
        ConvertSucess convertSucess = new ConvertSucess(new ObjectMapper());
        Optional<Data<Sucess>> convert = convertSucess.convert(responseSucess);
        Assert.assertTrue(convert.get().getData().isSucess());
    }

    @Test
    public void testConvertToJson() throws JsonProcessingException {
        ConvertSucess convertSucess = new ConvertSucess(new ObjectMapper());
        Optional<Data<Sucess>> convert = convertSucess.convert(responseSucess);
        Assert.assertTrue(convert.get().getData().isSucess());
        Optional<String> json = convertSucess.convertToJson(convert.get());
        Assert.assertTrue(json.get().contains("a6fe081f041bfbd349655e940c82d757"));
    }
}
