package com.concepts.elasticsearch.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SupervisorSerializer extends JsonSerializer<Employee> {

    @Override
    public void serialize(Employee employee, JsonGenerator generator, SerializerProvider arg2)
            throws IOException {
        generator.writeStartObject("supervisor");
        generator.writeObjectField("firstname", employee.getFirstName());
        generator.writeObjectField("lastname", employee.getLastName());
        generator.writeEndObject();
    }

}
