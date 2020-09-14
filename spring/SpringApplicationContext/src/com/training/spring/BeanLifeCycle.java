package com.training.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

	private String beanName;
	
	private String beanDescription;
	
	public String getBeanDescription() {
		return beanDescription;
	}

	public void setBeanDescription(String beanDescription) {
		this.beanDescription = beanDescription;
		System.out.println("Initialize the bean properties " + beanDescription + " --> ");
	}
	
	public void customInit() {
		System.out.println("Doing custom initialization --> ");
	}

	public void customDestroy() {		
		System.out.println("Doing custom destroy activities --> ");		
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying the bean --> ");		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set is invoked --> ");		
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("Process the bean after initialization " + bean + arg1 + " --> ");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("Process the bean before initialization " + bean + arg1 + " --> ");
		return bean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("Set the Application Context " + applicationContext + " --> ");		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Set the bean factory " + beanFactory + " --> ");		
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("Set the bean name " + beanName + " --> ");
	}

}
