package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.BearerToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertToken implements  IConvert<DataValue<BearerToken>>{
    private ObjectMapper objectMapper;
    public ConvertToken(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<BearerToken>> convert(String json) throws JsonProcessingException {
        DataValue<BearerToken> saidawriter = objectMapper.readValue(json,new TypeReference<DataValue<BearerToken>>(){});
        return Optional.ofNullable(saidawriter);
    }

    @Override
    public Optional<String> convertToJson(DataValue<BearerToken> token) throws JsonProcessingException {
        String sjson = objectMapper.writeValueAsString(token);
        return Optional.ofNullable(sjson);
    }
}
