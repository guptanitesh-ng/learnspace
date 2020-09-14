package com.concepts.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FinanceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println("@@@@@Finance@@@@@");
        System.out.println(System.getProperty("clu.properties.dir"));
        System.out.println(System.getProperty("cache.hccGroupConfiguration.ttl"));
        return application.sources(FinanceApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("&&&&&&&&&&&&&&&&&&");
        SpringApplication.run(FinanceApplication.class, args);
    }

}
