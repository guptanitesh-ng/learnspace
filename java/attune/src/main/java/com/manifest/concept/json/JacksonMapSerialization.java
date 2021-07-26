package com.manifest.concept.json;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

public class JacksonMapSerialization {

	private Map<DescriptionKey, Description> descriptionMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		new JacksonMapSerialization().map();
	}

	private void map() throws Exception {
		Description description = new Description(1, "name", false);

		descriptionMap.put(new DescriptionKey(description.getId()), description);
		ObjectMapper mapper = new ObjectMapper();
		mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), DefaultTyping.NON_FINAL, As.PROPERTY);

		StringWriter writer = new StringWriter();
		mapper.writeValue(writer, descriptionMap);
		System.out.println(writer);

		Map<?, ?> readValue = mapper.readValue(writer.toString().getBytes(), HashMap.class);
		readValue.entrySet().forEach(e -> System.out.println(e.getKey()));

	}
}
