package com.training.spring.shoppingcart;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {						
		final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		
		for (int count = 1; count <= 10; count++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {					
					Customer customer = appContext.getBean(Customer.class);
					Product bigBattery = (Product)appContext.getBean("bigBattery");
					Product cd = (Product)appContext.getBean("cd");
					Product smallBattery = (Product)appContext.getBean("smallBattery");
					Product dvd = (Product)appContext.getBean("dvd");
					Random random = new Random();
					customer.setAddress("Home Address" +random.nextInt(11));
					customer.setCustomerId("CUS100" +random.nextInt(11));
					customer.setName("My Name" + random.nextInt(11));					
					bigBattery.setQuantity(random.nextInt(11));
					customer.getCart().addItem(bigBattery);
					cd.setQuantity(random.nextInt(11));
					customer.getCart().addItem(cd);
					smallBattery.setQuantity(random.nextInt(11));
					customer.getCart().addItem(smallBattery);
					dvd.setQuantity(random.nextInt(11));
					customer.getCart().addItem(dvd);
					System.out.println(customer.checkout());
				}
			};
			new Thread(runnable).start();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		ProductRanking ranking = (ProductRanking)appContext.getBean(Quarter.third.name());
		ranking.printRankings();
		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor)appContext.getBean("executor");
		executor.shutdown();
	}

}
