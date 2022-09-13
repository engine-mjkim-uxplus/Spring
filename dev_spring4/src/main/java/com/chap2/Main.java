package com.chap2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// 나는 순수한 자바입니다
// 
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		DeptVO dVO = ctx.getBean("getDeptVO", DeptVO.class);
		int deptno = dVO.getDeptno();
		String dname = dVO.getDname();
		String dloc = dVO.getLoc();
		System.out.println(deptno+", "+ dname + ", " + dloc);
		
	}

}
