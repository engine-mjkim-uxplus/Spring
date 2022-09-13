<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// declaration - 클래스 선언, 메서드 선언
// test_jsp.java - 클래스이름 바뀐 -> test_jsp의 내부 클래스로 정의된다
// 프로젝트를 배포하는 서버마다 클래스이름의 명명규칙이 다르다??
// 우리가 인스턴스화한다? 
// 넌 인스턴스화 하지 말아라 - 메모리 관리 책임은 스프링이 책임져 준다.
// 자원관리를 프레임워크에게 맡긴다.
// 클래스 이름은 누가 결정해야 할까? - 업무구현할 개발자 결정한다.
// 제어역전(IoC)
// 이렇게 쓰며 자원관리를 스프링이 아닌 내가 해야하는 것이다. (쓰지 말 것)
// 단독으로 인스턴스화가 불가능
	class Sonata{
	
	}
%>
<%
	Sonata myCar = new Sonata();
	out.print(myCar);
	// 로컬PC
	// 웹서버(Web Application Server) <-> Web Server(정적페이지)
	// 유지 - scope(page|request|session|application)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- class에는 fullName 와야한다 --> 
<!-- 그러므로 선언문에 있는 것은 쓸 수 없고 클래스를 만들어서 사용 -->
<!-- xml문법 : jsp-namespace 
	프레임워크에 대한 환경 설정은 xml로 처리한다(spring2.5)
	myBatis+java연계
	myBatis+servlet연계(연동)
	
	ORM솔루션 - JDO, myBatis, Hibernate
	이종간에 연동(연계,결합,인터페이스)
	인스턴스화 - 객체주입 - mybatis-3.5.10 jar(클래스)
	xml끼리(xml내부에서 클래스간의 객체 주입이 되어야 한다)
	
	java - java
	: 컴파일 - 서버를 내렸다 추가하고 서버를 기동한다.
	
	useBean태그로 객체를 선언하는 것은 재사용이 어렵다.
	:test$Sonata.class라고 이름이 붙기 때문에
	앞에 jsp의 이름에 대한 클래스 이름이 서버제품마다 다르다(명명규칙이 달라서)
	
	클래스명은 개발자가 결정하는데 사용은 여러 개발자가 공유해야함
	동시접속자 많고 불특정 다수가 시도 때도 없이 사용함
	자원관리를 시스템에서 맡아주는게 효과적이지 않나?
	그래서 스프링은 제어역전 가져왔다
	spring-core.jar -> ApllicationContext, BeanFactory(빈을 관리한다) 
	단 대신 클래스에 대한 등록은 개발자가 한다
	
	BeanFactory 클래스 
	객체를 관리하는 고급 설정 기법 제공
	org.springframework.beans 내에 속함
	모든 Bean을 늦게 로딩(Lazy loading)함
	
	ApllicationContext 클래스 (컨테이너 역할)
	BeanFactory에 모든 기능을 제공함
	Spring의 AOP기능 제공
	메시지 지원 핸들링, 이벤트 위임
	org.springframework.context에 속함
	Context를 시작시킬 때 모든 SingleTon Bean을
	미리 로딩함으로써 그 Bean이 필요할 때 즉시 사용될 수 있도록 보장해줌
	애플리케이션 동작시 Bean이 생성되기를 기다릴 필요가 없게 됨
	
	스프링 core(엔진) 위에 컨테이너가 있다. 
	그 컨테이너의 한 이름이 BeanFactory, ApplicationContext
	객체에 대한 자원관리를 담당하는 컨테이너들이다.
-->
<jsp:useBean id="himCar" scope="request" class="com.di.Sonata"/>
</body>
</html>









