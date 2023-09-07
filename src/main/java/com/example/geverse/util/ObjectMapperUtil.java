package com.example.geverse.util;

import com.example.geverse.entity.GeneratedSequence;
import com.example.geverse.entity.PrepSequence;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperUtil {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String convertSequenceToJSON(PrepSequence sequence) {
        objectMapper.writer().withDefaultPrettyPrinter();

        try {
            return objectMapper.writeValueAsString(sequence);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public GeneratedSequence convertJSONToSequence(String response){
        try {
            return objectMapper.readValue(response, GeneratedSequence.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
