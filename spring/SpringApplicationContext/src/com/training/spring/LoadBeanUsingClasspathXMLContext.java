package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadBeanUsingClasspathXMLContext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/bean.xml");
		
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee.getId());
		
		Employee emp = context.getBean(Employee.class);
		System.out.println(emp.getName());
		
		System.out.println(employee.equals(emp));
		
		SingletonBean singletonBean = context.getBean(SingletonBean.class);
		System.out.println(singletonBean);
		
		BeanLifeCycle beanLifeCycle = context.getBean(BeanLifeCycle.class);
		System.out.println("Now the bean is ready for use " + beanLifeCycle + " --> ");
		
		PropertyInjectionOptions injectionOptions = context.getBean(PropertyInjectionOptions.class);
		System.out.println(injectionOptions.getSetType().size());
		System.out.println(injectionOptions.getTextType());
		
		AnnotationBasedWiring wiring = context.getBean(AnnotationBasedWiring.class);
		System.out.println(wiring.getValue());
		System.out.println(wiring.getEmployee().getId());
		
		Player player1 = (Player)context.getBean("playerPOJO");
		System.out.println(player1.getName());
		
		Player player2 = (Player)context.getBean("player");
		System.out.println(player2.getName());
		
		Player player3 = (SamplePlayer)context.getBean(SamplePlayer.class);
		System.out.println(player3.getMatchesPlayed());
	}

}
