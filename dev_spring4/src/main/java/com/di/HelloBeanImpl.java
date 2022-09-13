package com.di;
// 인터페이스에 대한 구현체 클래스
// 인터페이스 및 추상클래스로 하여야 결합도가 낮아지고 단위테스트가 가능해진다 (스프링의 근간)
public class HelloBeanImpl implements HelloBean {
	String msg = null;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getGreeting(String msg) {
		return "Spring!!! " + this.msg;
	}
	// this를 붙이고 안붙이고 차이!!!
	// this.msg -> 결과 : Spring!!! Hello Bean!!! 

}
