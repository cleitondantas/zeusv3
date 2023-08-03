package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertToken implements  IConvert<Data<Token>>{
    private ObjectMapper objectMapper;
    public ConvertToken(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<Data<Token>> convert(String json) throws JsonProcessingException {
        Data<Token> saidawriter = objectMapper.readValue(json,new TypeReference<Data<Token>>(){});
        return Optional.ofNullable(saidawriter);
    }
}
