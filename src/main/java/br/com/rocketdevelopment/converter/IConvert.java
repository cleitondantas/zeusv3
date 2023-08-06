package br.com.rocketdevelopment.converter;

import br.com.rocketdevelopment.exception.ConvertException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface IConvert<T> {

     Optional<T> convert(String json) throws ConvertException;

     Optional<String> convertToJson(T token) throws ConvertException;
}
