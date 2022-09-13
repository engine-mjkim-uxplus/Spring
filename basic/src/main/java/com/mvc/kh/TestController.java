package com.mvc.kh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@GetMapping("testList.sp4")
	public String testList() {
		logger.info("testList 호출");
//		return "forward:testList.jsp"; // viewResolve 안탐. [WEB-INF] 밖에 test/testList.jsp
		return "test/testList"; // [WEB-INF] 안에. viewResolve 탄다
	}
}
