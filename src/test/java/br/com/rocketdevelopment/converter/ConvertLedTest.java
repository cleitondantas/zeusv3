package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.Led;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ConvertLedTest {
    private String responseLed = "{\n" +
            "    \"data\": {\n" +
            "        \"enabled\": false,\n" +
            "        \"search\": false,\n" +
            "        \"active\": true,\n" +
            "        \"color\": {\n" +
            "            \"value\": \"green\",\n" +
            "            \"option_list\": [\n" +
            "                \"red\",\n" +
            "                \"green\",\n" +
            "                \"blue\",\n" +
            "                \"cyan\",\n" +
            "                \"magenta\",\n" +
            "                \"yellow\",\n" +
            "                \"white\",\n" +
            "                \"pink\",\n" +
            "                \"purple\",\n" +
            "                \"orange\",\n" +
            "                \"light blue\",\n" +
            "                \"light green\"\n" +
            "            ]\n" +
            "        },\n" +
            "        \"days_of_week\": {\n" +
            "            \"sun\": false,\n" +
            "            \"wed\": true,\n" +
            "            \"sat\": false,\n" +
            "            \"tue\": true,\n" +
            "            \"thu\": true,\n" +
            "            \"fri\": true,\n" +
            "            \"mon\": true\n" +
            "        },\n" +
            "        \"intervals\": [],\n" +
            "        \"action\": {\n" +
            "            \"value\": \"on\",\n" +
            "            \"option_list\": [\n" +
            "                \"on\",\n" +
            "                \"off\",\n" +
            "                \"blink\",\n" +
            "                \"pulse\",\n" +
            "                \"toggle\",\n" +
            "                \"radom\"\n" +
            "            ]\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Test
    public void testConvert() throws ConvertException {
        ConvertLed convertLed = new ConvertLed(new ObjectMapper());
        DataValue<Led> ledDataValue = convertLed.convert(responseLed)
                .orElseThrow(() -> new ConvertException("Failed to convert responseLed"));
        String actionValue = ledDataValue.getData().getAction().getValue();
        Assert.assertTrue(actionValue.equalsIgnoreCase("on"));
    }

    @Test
    public void testConvertToJson() throws ConvertException {
        ConvertLed convertLed = new ConvertLed(new ObjectMapper());
        DataValue<Led> ledDataValue = convertLed.convert(responseLed)
                .orElseThrow(() -> new ConvertException("Failed to convert responseLed"));
        String actionValue = ledDataValue.getData().getAction().getValue();
        Assert.assertTrue(actionValue.equalsIgnoreCase("on"));
        String jsonString = convertLed.convertToJson(ledDataValue)
                .orElseThrow(() -> new ConvertException("Failed to convert ledDataValue to JSON"));
        Assert.assertTrue(jsonString.contains("on"));
    }
}
