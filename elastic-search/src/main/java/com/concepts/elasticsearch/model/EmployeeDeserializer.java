package com.concepts.elasticsearch.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EmployeeDeserializer extends JsonDeserializer<Employee> {

    @Override
    public Employee deserialize(JsonParser parser, DeserializationContext arg1)
            throws IOException, JsonProcessingException {
        TreeNode node = parser.getCodec().readTree(parser);
        node.get("FirstName");
        node.get("LastName");
        node.get("Designation");
        node.get("Salary");
        node.get("DateOfJoining");
        node.get("Address");
        node.get("Gender");
        node.get("Age");
        node.get("MaritalStatus");
        node.get("Interests");

        return null;
    }

}
