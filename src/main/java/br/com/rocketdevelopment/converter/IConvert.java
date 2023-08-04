package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.model.Data;
import br.com.rocketdevelopment.model.Led;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface IConvert<T> {

     Optional<T> convert(String json) throws JsonProcessingException;

     Optional<String> convertToJson(T token) throws JsonProcessingException;
}
