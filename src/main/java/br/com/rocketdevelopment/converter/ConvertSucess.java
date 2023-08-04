package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Sucess;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertSucess implements IConvert<Data<Sucess>> {

    private ObjectMapper objectMapper;

    public ConvertSucess(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Data<Sucess>> convert(String json) throws JsonProcessingException {
        Data<Sucess> sucessData = objectMapper.readValue(json, new TypeReference<Data<Sucess>>() {});
        return Optional.ofNullable(sucessData);
    }

    @Override
    public Optional<String> convertToJson(Data<Sucess> sucess) throws JsonProcessingException {
        String sjson = objectMapper.writeValueAsString(sucess);
        return Optional.ofNullable(sjson);
    }
}
