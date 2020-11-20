package com.concepts.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ElasticSearchApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ElasticSearchApplication.class, args);
	}

}
