package com.training.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookShopClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/springtransaction.xml");
		BookShopDAO bookShopDAO = applicationContext.getBean(BookShopDAO.class);
		System.out.println(bookShopDAO.purchaseBook());
	}

}
