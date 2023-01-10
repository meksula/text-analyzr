package com.meksula.analyzr.analysis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@Converter
class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Integer> integers) {
        try {
            return objectMapper.writeValueAsString(integers);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while trying to serialize list of integers as string value");
            return "[]";
        }
    }

    @Override
    public List<Integer> convertToEntityAttribute(String columnValue) {
        if (isNull(columnValue)) {
            return Collections.emptyList();
        }
        try {
            return objectMapper.readValue(columnValue, objectMapper.getTypeFactory().constructCollectionType(List.class, Integer.class));
        } catch (JsonProcessingException exception) {
            log.error("Unexpectetly exception occurred while fetching list of integers from database", exception);
            return Collections.emptyList();
        }
    }
}
