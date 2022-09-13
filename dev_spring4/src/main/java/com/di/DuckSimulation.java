package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DuckSimulation {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/di/duckBean.xml");
		
		MallardDuck myDuck = (MallardDuck)context.getBean("myDuck");
		System.out.println(myDuck);
		myDuck.display();
		myDuck = (MallardDuck)context.getBean("myDuck");
		System.out.println(myDuck);
		System.out.println("myDuck leg : " + myDuck.leg);
		System.out.println("myDuck name : " + myDuck.name);
		myDuck.display();
		myDuck = new MallardDuck();
		System.out.println(myDuck);
		// prototype은 새로운 객체를 계속 만든다(himDuck)
		Duck himDuck = (Duck)context.getBean("himDuck");
		System.out.println(himDuck);
		System.out.println("himDuck leg : " + himDuck.leg);
		System.out.println("himDuck name : " + himDuck.name);
		himDuck.display();
		himDuck = (Duck)context.getBean("himDuck");
		System.out.println(himDuck);
		
		
		
	}
}
