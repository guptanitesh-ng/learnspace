package com.training.spring.shoppingcart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductStore {

	@Bean(name="smallBattery")
	public Product getSmallBattery() {
		return new Battery("Small Battery", 20, true);
	}
	
	@Bean(name="bigBattery")
	public Product getBigBattery() {
		return new Battery("Large Battery", 40, false);
	}
	
	@Bean(name="dvd")
	public Product getDVD() {
		return new Disc("DVD", 35, false);
	}
	
	@Bean(name="cd")
	public Product getCD() {
		return new Disc("CD", 20, true);
	}
	
	@Bean(name="first")
	public ProductRanking getFirstQuarterRanking() {		
		return new ProductRanking(Quarter.first);
	}
	
	@Bean(name="second")
	public ProductRanking getSecondQuarterRanking() {		
		return new ProductRanking(Quarter.second);
	}
	
	@Bean(name="third")	
	public ProductRanking getThirdQuarterRanking() {		
		return new ProductRanking(Quarter.third);
	}
	
	@Bean(name="last")
	public ProductRanking getLastQuarterRanking() {		
		return new ProductRanking(Quarter.last);
	}
}
