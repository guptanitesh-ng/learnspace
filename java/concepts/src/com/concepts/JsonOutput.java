package com.concepts;

import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonOutput {

    private static final String WORK_TYPE_DESCRIPTION = "WorkTypeRestControllerIntegrationTest";
    private static final String WORK_TYPE_CODE = "8766";
    private static final Boolean WORK_TYPE_SKIP_EXTRACTION = Boolean.TRUE;

    public static void main(String[] args) throws Exception {
        WorkType workType = new WorkType();
        workType.setDescription(WORK_TYPE_DESCRIPTION);
        workType.setWorkTypeCode(WORK_TYPE_CODE);
        workType.setSkipExtraction(WORK_TYPE_SKIP_EXTRACTION);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, workType);
        System.out.println(writer);
    }
}
