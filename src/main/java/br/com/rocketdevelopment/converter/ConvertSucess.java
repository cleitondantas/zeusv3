package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.SystemSucess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertSucess implements IConvert<DataValue<SystemSucess>> {

    private final ObjectMapper objectMapper;

    public ConvertSucess(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<SystemSucess>> convert(String json) throws ConvertException{
        DataValue<SystemSucess> sucessData = null;
        try {
            sucessData = objectMapper.readValue(json, new TypeReference<DataValue<SystemSucess>>() {});
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<SystemSucess>.",e);
        }

        return Optional.ofNullable(sucessData);
    }

    @Override
    public Optional<String> convertToJson(DataValue<SystemSucess> sucess)throws ConvertException {
        String sjson = null;
        try {
         sjson = objectMapper.writeValueAsString(sucess);
    } catch (JsonProcessingException e) {
        throw new ConvertException("Error converting json to DataValue<SystemSucess>.",e);
    }
        return Optional.ofNullable(sjson);
    }
}
