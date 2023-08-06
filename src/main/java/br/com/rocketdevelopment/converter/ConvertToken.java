package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.BearerToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertToken implements  IConvert<DataValue<BearerToken>>{
    private final ObjectMapper objectMapper;
    public ConvertToken(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<BearerToken>> convert(String json) throws ConvertException {
        DataValue<BearerToken> saidawriter = null;
        try {
            saidawriter = objectMapper.readValue(json, new TypeReference<DataValue<BearerToken>>() {});
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<BearerToken>.",e);
        }
        return Optional.ofNullable(saidawriter);
    }

    @Override
    public Optional<String> convertToJson(DataValue<BearerToken> token) throws ConvertException {
        String sjson = null;
        try {
            sjson = objectMapper.writeValueAsString(token);
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting DataValue<BearerToken> to json.",e);
        }
        return Optional.ofNullable(sjson);
    }
}
