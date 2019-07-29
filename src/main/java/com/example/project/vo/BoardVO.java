package com.example.project.vo;

import java.util.Date;

public class BoardVO {
	//사용할 데이터 정보 관리 ==> 테이블의 필드 목록만크 만듬

	private int bno; //글번호
	private String title; //글제목
	private String context; //글 내용
	private String writer; //작성자
	private Date regdate; // 작성날자
	private int viewcnt; //조회수
	private String userName; //사용자 이름 --> getter / setter추가
	
	//getter/setter 추가
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	//사용자 이름  getter / setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", context=" + context + ", writer=" + writer + ", regdate="
				+ regdate + ", viewcnt=" + viewcnt + ", userName=" + userName + "]";
	}
}
