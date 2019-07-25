package com.example.project.service;

import java.util.List;
import com.example.project.vo.MemberVO;

public interface MemberService {
	//회원목록
	public List<MemberVO> memberList();
	
	//회원등록
	public void insertMember (MemberVO vo);
	
	//회원상세보기
	public MemberVO viewMember(String userId);
	
	//회원삭제
	public void deleteMember(String userId);
	
	//회원수정
	public void updateMember(MemberVO vo);
	
	//비번체크메서드 (추가)
	public boolean checkPw(String userId, String userPw);

}
