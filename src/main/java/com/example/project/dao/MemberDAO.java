package com.example.project.dao;

import java.util.List;

import com.example.project.vo.MemberVO;


public interface MemberDAO {
	
	//회원목록
	public List<MemberVO> memberList();
	
	//회원 등록
	public void insertMember(MemberVO vo);
	
	//회운 상세보기
	public MemberVO viewMember(String userId);
	
	//회원 삭제
	public void deleteMember(String userId);
	
	//회원 수정
	public void updateMember(MemberVO vo);
	
	//비번 체크하는 메서드(추가)
	public boolean checkPw(String userId, String userPw);

}
