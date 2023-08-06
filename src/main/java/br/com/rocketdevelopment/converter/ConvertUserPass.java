package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.BearerToken;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.UserPass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ConvertUserPass implements IConvert<DataValue<UserPass>> {
    private final ObjectMapper objectMapper;

    public ConvertUserPass(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<UserPass>> convert(String json) throws ConvertException {
        DataValue<UserPass> userpass = null;
        try {
            userpass = objectMapper.readValue(json, new TypeReference<DataValue<UserPass>>() {});
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<UserPass>.",e);
        }
        return Optional.ofNullable(userpass);
    }

    @Override
    public Optional<String> convertToJson(DataValue<UserPass> userPass) throws ConvertException {
        String userpass = null;
        try {
            userpass = objectMapper.writeValueAsString(userPass);
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<UserPass>.", e);
        }
        return Optional.ofNullable(userpass);
    }
}
