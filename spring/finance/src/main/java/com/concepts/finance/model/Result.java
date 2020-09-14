package com.concepts.finance.model;

public class Result {

    private String value;

    private Integer duration;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Result [value=" + value + ", duration=" + duration + "]";
    }

}
