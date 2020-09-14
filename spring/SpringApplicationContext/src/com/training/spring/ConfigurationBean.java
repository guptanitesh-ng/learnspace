package com.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

	@Bean(name="player")
	public Player createPlayer() {
		return new Player("CPU", 100);
	}
}

