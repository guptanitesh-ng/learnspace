package com.concepts.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concepts.finance.model.Input;
import com.concepts.finance.service.CalculatorService;

@RestController
public class CalculatorController {    

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/hello")
    public String sayHello(
            @RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            String user = authentication.getName();
            System.out.println("Logged in user : " + user);
        }
        Input input = new Input();
        input.setType(name);
        calculatorService.compute(input);
        return "Sali " + name + "!!!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/check-csrf")
    public void handleRequest(@RequestBody Object payload) {
        System.out.println("Received payload: " + payload);
    }
}
