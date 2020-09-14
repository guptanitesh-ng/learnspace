package com.training.spring.ioc.generator.sequence;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"META-INF/beans.xml");
		final SequenceGenerator sequenceGenerator = applicationContext
				.getBean(SequenceGenerator.class);
		for (int count = 1; count <= 10; count++) {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					String firstValue = sequenceGenerator.generateSequence();
					System.out.println(firstValue);
				}
			};
			new Thread(runnable).start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor)applicationContext.getBean("executor");
		executor.shutdown();
	}

}
