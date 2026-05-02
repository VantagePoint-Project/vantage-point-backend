package com.vantagepoint.backend.infrastructure.common.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FORMAT_1 =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter FORMAT_2 =
            DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @SneakyThrows
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) {
        String value = p.getText();

        try {
            return LocalDateTime.parse(value, FORMAT_1);
        } catch (Exception e) {
            return LocalDateTime.parse(value, FORMAT_2);
        }
    }
}