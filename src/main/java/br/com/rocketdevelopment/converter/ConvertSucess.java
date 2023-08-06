package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.SystemSucess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertSucess implements IConvert<DataValue<SystemSucess>> {

    private ObjectMapper objectMapper;

    public ConvertSucess(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<SystemSucess>> convert(String json) throws JsonProcessingException {
        DataValue<SystemSucess> sucessData = objectMapper.readValue(json, new TypeReference<DataValue<SystemSucess>>() {});
        return Optional.ofNullable(sucessData);
    }

    @Override
    public Optional<String> convertToJson(DataValue<SystemSucess> sucess) throws JsonProcessingException {
        String sjson = objectMapper.writeValueAsString(sucess);
        return Optional.ofNullable(sjson);
    }
}
