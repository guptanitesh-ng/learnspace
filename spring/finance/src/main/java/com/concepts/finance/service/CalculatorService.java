package com.concepts.finance.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.concepts.finance.model.Input;
import com.concepts.finance.model.Result;

@Service
public class CalculatorService {

    @Cacheable(value = "compute")
    public Result compute(Input input) {
        System.out.println("Inside compute");
        Result result = new Result();
        result.setDuration(50);
        result.setValue(input.getType());
        return result;
    }
}
