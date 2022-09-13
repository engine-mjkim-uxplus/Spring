package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/di/helloBean.xml");
		HelloBean helloBean = (HelloBean)context.getBean("helloBean");
		System.out.println(helloBean.getGreeting("헬로~~~")); // this.msg 사용할 경우 xml의 <value>Hello Bean!!!</value> 출력. 헬로~~무시된다.
		
	}

}

