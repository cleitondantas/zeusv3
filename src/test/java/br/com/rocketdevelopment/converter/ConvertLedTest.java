package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
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
    public void testConvert() throws JsonProcessingException {
        ConvertLed convertLed = new ConvertLed(new ObjectMapper());
        Optional<Data<Led>> convert = convertLed.convert(responseLed);
        Assert.assertTrue(convert.get().getData().getAction().getValue().equalsIgnoreCase("on"));
    }

    @Test
    public void testConvertToJson() throws JsonProcessingException {
        ConvertLed convertLed = new ConvertLed(new ObjectMapper());
        Optional<Data<Led>> convert = convertLed.convert(responseLed);
        Assert.assertTrue(convert.get().getData().getAction().getValue().equalsIgnoreCase("on"));
        Optional<String> json = convertLed.convertToJson(convert.get());
        Assert.assertTrue(json.get().contains("on"));
    }
}
