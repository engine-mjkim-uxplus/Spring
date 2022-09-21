package com.spring4.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.google.gson.Gson;
import com.util.HashMapBinder;

//여기선 어노테이션 사용하지 않는다.
//@RestControlle
public class BoardController  extends MultiActionController{
	Logger logger = Logger.getLogger(BoardController.class);
	private BoardLogic boardLogic = null;
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	// http://localhost:9000/dev_spring4/board/jsonBoardList.sp
	public String jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("jsonBoardList호출 성공");
		Map<String,Object> pMap = new HashMap<>();//@RequestParam Map<String,Object> pMap
		List<Map<String,Object>> boardList = null; 
		boardList = boardLogic.boardList(pMap);
		//model.addAttribute("boardList", boardList);//scope:request
		req.setAttribute("boardList", boardList);
		logger.info(boardList);
		return "forward:jsonBoardList.jsp";
	}
	// http://localhost:9000/dev_spring4/board/BoardList.sp
	public String boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList호출 성공");
		Map<String,Object> pMap = new HashMap<>();//@RequestParam Map<String,Object> pMap
		List<Map<String,Object>> boardList = null; 
		boardList = boardLogic.boardList(pMap);
		//model.addAttribute("boardList", boardList);//scope:request
		req.setAttribute("boardList", boardList);
		logger.info(boardList);
		return "forward:boardList.jsp";
	}
	// http://localhost:9000/dev_spring4/board/BoardDetail.sp
	public String boardDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDetail 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		List<Map<String,Object>> boardList = null; 
		boardList = boardLogic.boardDetail(pMap);
		req.setAttribute("boardList", boardList);
		return "forward:read.jsp";
	}
	// http://localhost:9000/dev_spring4/board/BoardInsert.sp
	public String boardInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardInsert 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		//hmb.bind(pMap);
		hmb.multiBind(pMap); // 첨부파일
		boardLogic.boardInsert(pMap);
		//redirect-forward, forward->forward(에러)
		return "redirect:boardList.sp";
	}
	// http://localhost:9000/dev_spring4/board/BoardUpdate.sp
	public String boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardUpdate 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		boardLogic.boardUpdate(pMap);
		//redirect-forward, forward->forward(에러)
		return "redirect:boardList.sp";
	}
	// http://localhost:9000/dev_spring4/board/BoardDelete.sp
	public String boardDelete(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDelete 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		boardLogic.boardDelete(pMap);
		//redirect-forward, forward->forward(에러)
		return "redirect:boardList.sp";
	}

}
