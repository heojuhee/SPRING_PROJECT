package com.example.project.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.project.vo.MemberVO;

@Repository // 빈생성
public class LoginDAOImpl implements LoginDAO {

	// 주입
	@Inject
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("login.loginCheck", vo);
		return (name == null) ? false : true;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		return sqlSession.selectOne("login.viewMember", vo);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub

	}

}
