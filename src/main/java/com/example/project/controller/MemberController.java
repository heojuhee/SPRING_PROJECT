package com.example.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.service.MemberService;
import com.example.project.vo.MemberVO;

@Controller //controller 빈등록
public class MemberController {
	
	@Inject //주입
	MemberService memberService;
	
	//회원 목록
	@RequestMapping("member/list")
	public String memberList(Model model) {
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	//회원등록
	//1) 등록 폼
	@RequestMapping("member/write")
	public String memberWrite() {
		return "member/member_write"; //member_write.jsp
	}
	
	//2) 실제 등록하면 처리할 메서드
	@RequestMapping("member/insert")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list";
	}
	
	//3) 회원 상세보기 
	@RequestMapping("member/view")
	public String memberView(@RequestParam String userId, Model model) {
		model.addAttribute("dto", memberService.viewMember(userId));
		//logger.info("클랙한 id" + user id);
		return "member/member_view";
	}
	
	//4) 회원 삭제
	@RequestMapping("member/delete")
	public String memberDelete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		boolean result = memberService.checkPw(userId, userPw);
		if(result) {
			memberService.deleteMember(userId);
			return "redirect:/member/list";
		} else {
			model.addAttribute ("message", "비번 불일치");
			model.addAttribute ("dto", memberService.viewMember(userId));
			return "member/member_view";
		}
	}
	
	//5) 회원 수정
	@RequestMapping("member/update")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model) {
		boolean result = memberService.checkPw(vo.getUserId(), vo.getUserPw());
		if(result) {
			memberService.updateMember(vo);
			return "redirect:/member/list";
		} else {
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setUserRegdate(vo2.getUserRegdate());
			vo.setUserUpdatedate(vo2.getUserUpdatedate());
			model.addAttribute("dto", vo);
			model.addAttribute("message", "불일치");
			return "member/member_view";
		} 
	}
}
