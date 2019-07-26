package com.example.project.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.project.vo.BoardVO;

public interface BoardService {
	//1) 작성
	public void create(BoardVO vo) throws Exception;
	
	//2) 보기
	public BoardVO read(int bno) throws Exception;
	
	//3) 수정
	public void update(BoardVO vo) throws Exception;
	
	//4) 삭제
	public void delete (int bno) throws Exception;
	
	//5)전체보기
	//public List<BoardVO> listAll() throws Exception;
	
	//5-2) 검색어를 이용한 전체 글 보기
//	public List<BoardVO> listAll
//	(String searchOption, String keyword) throws Exception;
	
	//5-3) 페이지 범위
	public List<BoardVO> listAll (int start, int end, String searchOption, String keyword) throws Exception;
	
	//6) 조회수
	public void increaseViewcnt
	(int bno, HttpSession session) throws Exception;

	//7) 갯수
	public int countArticle
	(String searchOption, String keyword) throws Exception;
}
