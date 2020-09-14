package com.training.spring;

public class SingletonBean {

	private static SingletonBean singletonBean = new SingletonBean();
	
	private SingletonBean() {
		
	}
	
	public static SingletonBean getInstance() {
		return singletonBean;
	}
}
