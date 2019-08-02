package com.example.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.project.vo.ReplyVO;

public interface ReplyService {
	
	//1) 목록
	public List<ReplyVO> list(Integer bno, HttpSession session );
	
	//2) 작성
	public void create(ReplyVO vo);
	
	//3) 수정
	public void update(ReplyVO vo);
	
	//4) 삭제
	public void delete(Integer rno);

}
