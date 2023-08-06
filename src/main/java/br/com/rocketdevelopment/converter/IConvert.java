package br.com.rocketdevelopment.converter;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface IConvert<T> {

     Optional<T> convert(String json) throws JsonProcessingException;

     Optional<String> convertToJson(T token) throws JsonProcessingException;
}
