package com.example.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.project.dao.ReplyDAO;
import com.example.project.vo.ReplyVO;

@Service //빈등록
public class ReplyServiceImpl implements ReplyService {
	
	//주입
	@Inject
	ReplyDAO replyDao;

	@Override
	public List<ReplyVO> list(Integer bno) {
		return replyDao.list(bno);
	}

	@Override
	public void create(ReplyVO vo) {
		replyDao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		replyDao.update(vo);
	}

	@Override
	public void delete(Integer rno) {
		replyDao.delete(rno);
	}

}
