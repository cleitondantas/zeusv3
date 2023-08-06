package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import br.com.rocketdevelopment.model.DataValue;
import br.com.rocketdevelopment.model.Led;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

public class ConvertLed  implements IConvert<DataValue<Led>>{

    private final ObjectMapper objectMapper;
    public ConvertLed(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<DataValue<Led>> convert(String json) throws ConvertException {
        DataValue<Led> saidawriter = null;
        try {
            saidawriter = objectMapper.readValue(json, new TypeReference<DataValue<Led>>() {});
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<Led>.",e);
        }
        return Optional.ofNullable(saidawriter);
    }

    @Override
    public Optional<String> convertToJson(DataValue<Led> led) throws ConvertException {
        String sjson = null;
        try {
            sjson = objectMapper.writeValueAsString(led);
        } catch (JsonProcessingException e) {
            throw new ConvertException("Error converting json to DataValue<Led>.",e);
        }
        return Optional.ofNullable(sjson);
    }


}
