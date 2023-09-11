package com.mycompany.yogitour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.interceptor.Login;
import com.mycompany.yogitour.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;	
	
	@GetMapping("/test1")
	public void test1(HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("bno", 1);
		jsonObject.put("btitle", "유럽 사진");
		jsonObject.put("bcontent", "여행 패키지 상품을 소개합니다.");
		
		String json = jsonObject.toString();
		
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	
	@GetMapping(value="/test2", produces="application/json; charset=UTF-8")
	public String test2(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("bno", 2);
		jsonObject.put("btitle", "유럽 사진2");
		jsonObject.put("bcontent", "여행 패키지2 상품을 소개합니다.");
		
		String json = jsonObject.toString();
		
		return json;
	}
	
	@GetMapping(value="/test3", produces="application/json; charset=UTF-8")
	public Board test3(){
		
		Board board = new Board();
		board.setBno(3);
		board.setBtitle("유럽 사진3");
		board.setBcontent("여행 패키지3 상품을 소개합니다.");
		
		return board;
	}
	
	@GetMapping(value="/getBoardList", produces="application/json; charset=UTF-8")
	public List<Board> getBoardList(){
		return boardService.getList();
	}
	
	@GetMapping(value="/getBoard", produces="application/json; charset=UTF-8")
	public Board getBoard(int bno){
		return boardService.getBoard(bno);
	}
	
	@GetMapping(value="/fileDownload", produces="image/jpeg")
	public byte[] fileDownload(int bno){
		Board board = boardService.getBoardOnlyAttachData(bno);
		return board.getBattachdata();
	}
	
	@Login
	@PostMapping(value="/writeBoard", produces="application/json; charset=UTF-8")
	public String writeBoard(Board board) {
			
		JSONObject jsonObject = new JSONObject();
		
		try {
			
			MultipartFile mf = board.getBattach();
			
			if(!mf.isEmpty()) {
				board.setBattachtype(mf.getContentType());
				board.setBattachdata(mf.getBytes());
			}
			
			boardService.write(board);
			
			jsonObject.put("result", "success");
			jsonObject.put("bno", board.getBno());
			
		} catch (Exception e) {
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		
		return jsonObject.toString();

	}
	
}
