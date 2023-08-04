package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Led;
import br.com.rocketdevelopment.model.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertLed  implements IConvert<Data<Led>>{

    private ObjectMapper objectMapper;
    public ConvertLed(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Data<Led>> convert(String json) throws JsonProcessingException {
        Data<Led> saidawriter = objectMapper.readValue(json,new TypeReference<Data<Led>>(){});
        return Optional.ofNullable(saidawriter);
    }

    @Override
    public Optional<String> convertToJson(Data<Led> led) throws JsonProcessingException {
        String sjson = objectMapper.writeValueAsString(led);
        return Optional.ofNullable(sjson);
    }


}
