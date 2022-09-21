package com.basic.step1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/board/*")
public class RestBoardController {

	// http://localhost:9000/step1/board/helloWorld.sp4
	@GetMapping(value="hangul.sp4", produces="text/plain;charset=UTF8") //produces="text/plain;charset=UTF8 -> 한글처리
	public String helloWorld() {
	    return "한글처리";
	}
	
	// http://localhost:9000/step1/board/jsonFormat.sp4
	@GetMapping(value="jsonNames.sp4", produces="application/json;charset=UTF8") //produces="text/plain;charset=UTF8 -> 한글처리
	public String jsonFormat() {
		List<Map<String,Object>> names = new ArrayList();
		Map<String,Object> rmap = new HashMap();
		rmap.put("mem_id", "tomato");
		rmap.put("mem_name", "토마토");
		names.add(rmap);
		rmap = new HashMap();
		rmap.put("mem_id", "apple");
		rmap.put("mem_name", "사과");
		names.add(rmap);
		Gson g = new Gson();
		String temp = g.toJson(names);
	    return temp;
	} 
	
}
