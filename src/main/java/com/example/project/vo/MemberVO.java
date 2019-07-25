package com.example.project.vo;

import java.sql.Date;

public class MemberVO {
	//테이블 필드목록만큼 선언
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userRegdate;
	private String userUpdatedate; //java.sql.date로 import
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(String userRegdate) {
		this.userRegdate = userRegdate;
	}
	public String getUserUpdatedate() {
		return userUpdatedate;
	}
	public void setUserUpdatedate(String userUpdatedate) {
		this.userUpdatedate = userUpdatedate;
	} //java.sql.date.로 import

	//getter/setter 추가
	
	
}
