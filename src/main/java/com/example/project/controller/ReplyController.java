package com.example.project.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.ReplyService;
import com.example.project.vo.ReplyVO;

@Controller //혹은 @RestConroller 중에 하나 // 빈등록
public class ReplyController {
	
	//주입
	@Inject
	ReplyService replyService; 
	
	//1) 댓글 입력 폼
	@RequestMapping("reply/insert")
	public void insert(@ModelAttribute ReplyVO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setReplyer(userId);
		replyService.create(vo);
	}
	
	//2) 댓글 목록 -> controller이용 -> 부화면을 따로 만듬 
	@RequestMapping("reply/list")
	public ModelAndView list(@RequestParam int bno, ModelAndView mav) {
		List<ReplyVO> list = replyService.list(bno);
		mav.addObject("list", list);
		mav.setViewName("board/replyList");
				return mav;
	}
	
	//3) 댓글 목록 -> RestController 이용 -> ajax로 전달된 값을
	@RequestMapping("reply/listjson")
	@ResponseBody //리턴 데이터를 json으로 변환
	public List<ReplyVO> listJson(@RequestParam int bno){
		List<ReplyVO> list = replyService.list(bno);
		return list;
	}
}















