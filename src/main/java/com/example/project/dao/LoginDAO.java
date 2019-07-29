package com.example.project.dao;

import javax.servlet.http.HttpSession;

import com.example.project.vo.MemberVO;

public interface LoginDAO {
	
	//1. 회원 로그인 체크
	public boolean loginCheck(MemberVO vo);
	
	//2. 회원 정보보기
	public MemberVO viewMember(MemberVO vo);
	
	//3. 회원로그아웃
	public void logout(HttpSession session);
}
