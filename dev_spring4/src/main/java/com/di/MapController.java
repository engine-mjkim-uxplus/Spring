package com.di;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {
	Logger logger = Logger.getLogger(ListController.class);
	//spring-servlet.xml에 선언된 bean[MapController]태그안에 정의된
	private Map<String,String> insaMsg = null; // 주입받고 싶다. 누가(스프링에서 필요할 때 - 게으른 인스턴스화[BeanFactory], 이른[ApplicationContext])
	// setter메소드는 setter 객체주입법 코드임
	// 그 객체는 어디에 있는 객체인가요? -> spring-servlet.xml Map
	public void setInsaMsg(Map<String, String> insaMsg) {
		this.insaMsg = insaMsg;
	}
	//dev_spring4/di/insaMap.sp
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		logger.info("handleRequestInternal==>" +insaMsg);
		return null;
	}
}
