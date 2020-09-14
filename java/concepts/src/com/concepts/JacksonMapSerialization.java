package com.concepts;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;

public class JacksonMapSerialization {

    private Map<ClarificationDescriptionFamilyKindKey, ClarificationDescription> descriptionMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        new JacksonMapSerialization().map();
    }

    private void map() throws Exception {
        ClarificationDescription description = new ClarificationDescription(1, null, 1, 1, "name",
                1, "moreInfo", false);

        descriptionMap.put(new ClarificationDescriptionFamilyKindKey(description.getFamilyID(),
                description.getKindID()), description);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping(DefaultTyping.NON_FINAL, As.PROPERTY);
        /*
         * mapper.registerModule( new
         * SimpleModule().addKeySerializer(ClarificationDescriptionFamilyKindKey.class, new
         * ClarificationDescriptionFamilyKindKeySerializer())); mapper.registerModule( new
         * SimpleModule().addKeyDeserializer(ClarificationDescriptionFamilyKindKey.class, new
         * ClarificationDescriptionFamilyKindKeyDeserializer()));
         */

        ClarificationMap map = new ClarificationMap();
        map.setClarificationMap(descriptionMap);
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, descriptionMap);
        System.out.println(writer);

        TypeReference<HashMap<ClarificationDescriptionFamilyKindKey, ClarificationDescription>> typeRef = new TypeReference<HashMap<ClarificationDescriptionFamilyKindKey, ClarificationDescription>>() {};
        Map<?, ?> readValue = mapper.readValue(writer.toString().getBytes(), HashMap.class);
        readValue.entrySet().forEach(e -> System.out.println(e.getKey().getClass()));
        // System.out.println(readValue.entrySet().);
    }
}
