package com.example.project.dao;

import java.util.List;

import com.example.project.vo.BoardVO;

public interface BoardDAO {
	//1) 게시글 작성
	public void create(BoardVO vo) throws Exception;
	
	//2) 게시글 상세보기
	public BoardVO read(int bno) throws Exception;
	
	//3) 게시글 수정
	public void update(BoardVO vo) throws Exception;	
	
	//4) 게시글 삭제
	public void delete(int bno) throws Exception;	
	
	//5-1) 게시글 전체 목록
	//public List<BoardVO> listAll() throws Exception;	
	
	//5-2) 검색어를 이용한 목록
	//public List<BoardVO> listAll(String serachOption, String keyword) throws Exception;
	
	//5-3) 페이지 목록 만들기
	public List<BoardVO> listAll(int start, int end, String serachOption, String keyword) throws Exception; 
	
	//6) 조회수
	public void increaseViewcnt(int bno) throws Exception;
	
	//7) 검색어로 검색한 글의 목록 갯수
	public int countArticle(String searchOption, String keyword)throws Exception;
}
