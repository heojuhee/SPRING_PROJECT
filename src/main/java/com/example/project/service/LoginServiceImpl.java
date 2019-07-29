package com.example.project.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.project.dao.LoginDAO;
import com.example.project.vo.MemberVO;

@Service //빈등록
public class LoginServiceImpl implements LoginService {
	
	@Inject //주입
	LoginDAO loginDao;

	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		boolean result = loginDao.loginCheck(vo);
		if(result) {
			MemberVO vo2 = viewMember(vo);
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
		}
		return result;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return loginDao.viewMember(vo);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();//세션연결 해제
		//session.removeAttribute("userId");
	}

}
