package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.Led;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

public class ConvertLed  implements IConvert<DataValue<Led>>{

    private ObjectMapper objectMapper;
    public ConvertLed(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<Led>> convert(String json) throws JsonProcessingException {
        DataValue<Led> saidawriter = objectMapper.readValue(json,new TypeReference<DataValue<Led>>(){});
        return Optional.ofNullable(saidawriter);
    }

    @Override
    public Optional<String> convertToJson(DataValue<Led> led) throws JsonProcessingException {
        String sjson = objectMapper.writeValueAsString(led);
        return Optional.ofNullable(sjson);
    }


}
