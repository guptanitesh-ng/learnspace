package com.concepts.elasticsearch.model;

public class Project {

    private String name;
    private String code;

    public Project(String name, String code) {
        super();
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Project [name=" + name + ", code=" + code + "]";
    }

}
