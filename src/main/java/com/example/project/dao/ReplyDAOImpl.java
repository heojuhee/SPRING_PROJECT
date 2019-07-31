package com.example.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.project.vo.ReplyVO;

@Repository //빈등록
public class ReplyDAOImpl implements ReplyDAO {
	
	//주입
	@Inject
	SqlSession sqlSession;

	@Override
	public List<ReplyVO> list(Integer bno) {
		return sqlSession.selectList("reply.listReply", bno);
	}

	@Override
	public void create(ReplyVO vo) {
		sqlSession.insert("reply.insertReply", vo);
	}

	@Override
	public void update(ReplyVO vo) {
		sqlSession.update("reply.updateReply", vo);
	}

	@Override
	public void delete(Integer rno) {
		sqlSession.delete("reply.deleteReply");
	}

}
