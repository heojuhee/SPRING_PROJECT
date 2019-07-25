package com.example.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.project.vo.MemberVO;

@Repository //dao를 빈으로 등록
public class MemberDAOImpl implements MemberDAO {
	
	@Inject //주입
	SqlSession sqlSession; //db연결 변수 

	@Override // 회원목록보기 구현  
	public List<MemberVO> memberList() {
		return sqlSession.selectList("member.memberList");
		//mybatis제공해주는 메서드
		//한개의 레코드값 조회 : selectOne
		//여러개의 레코드값 조회 : selectList, selectMap
		//selectList("매퍼파일의 네임스페이스이름.id명");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);

	}

	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member.viewMember", userId);
	}

	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember", userId);

	}

	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.delete("member.updateMember", vo);

	}

	@Override
	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPw",map);
		if(count ==1) {
			return true; 
		}
		return false;
	}

}
