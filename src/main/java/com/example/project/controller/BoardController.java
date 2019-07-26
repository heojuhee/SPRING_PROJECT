package com.example.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BoardPager;
import com.example.project.service.BoardService;
import com.example.project.vo.BoardVO;

@Controller // 컨트롤러 역할을 하는 빈 등록
public class BoardController {

	@Inject // 주입
	BoardService boardService;

	// 1-1) 리스트 (게시글 목록)
//	@RequestMapping("board/list")
//	public ModelAndView list() throws Exception{
//		List<BoardVO> list = boardService.listAll();
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("list", list);
//		mav.setViewName("board/list");
//		return mav;
//	}

//	//1-2) 리스트(검색 기능이 있는 게시글 목록)
//	@RequestMapping("board/list")
//	public ModelAndView list
//	(@RequestParam(defaultValue = "title") String searchOption, @RequestParam(defaultValue="")String keyword)
//	throws Exception{
//		List<BoardVO> list = boardService.listAll(searchOption, keyword);
//		int count = boardService.countArticle(searchOption, keyword);
//		
//		ModelAndView mav = new ModelAndView();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", list);
//		map.put("count", count);
//		map.put("searchOption" ,searchOption);
//		map.put("keyword", keyword);
//		mav.addObject("map", map);
//		mav.setViewName("board/list");
//		
//		return mav;
//	}

	// 1-3) 리스트(검색 기능이 있는 게시글 목록)
	@RequestMapping("board/list")
		public ModelAndView list
		(@RequestParam(defaultValue = "title") String searchOption, 
		 @RequestParam(defaultValue="")String keyword,
		 @RequestParam(defaultValue = "1") int curPage)
		throws Exception{
		
			int count = boardService.countArticle(searchOption, keyword);
			
			//페이지 나누기 관련 클래스
			BoardPager boardPager = new BoardPager(count, curPage);
			int start = boardPager.getPageBegin();
			int end=boardPager.getPageEnd();
			List<BoardVO> list = boardService.listAll(start, end, searchOption, keyword);
			
			ModelAndView mav = new ModelAndView();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("count", count);
			map.put("searchOption" ,searchOption);
			map.put("keyword", keyword);
			map.put("boardPager", boardPager);
			mav.addObject("map", map);
			mav.setViewName("board/list");
			
			return mav;
		}

	// 2) 등록폼
	@RequestMapping(value = "board/write", method = RequestMethod.GET)
	public String writer() {
		return "board/write";
	}

	// 3) 등록
	@RequestMapping(value = "board/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo) throws Exception {
		boardService.create(vo);
		return "redirect:list";
	}

	// 4) 게시물 상세보기
	@RequestMapping(value = "board/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		boardService.increaseViewcnt(bno, session);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", boardService.read(bno));
		mav.setViewName("board/view");
		return mav;
	}

	// 5) 수정
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		boardService.update(vo);
		return "redirect:list";
	}

	// 6) 삭제
	@RequestMapping(value = "board/delete", method = RequestMethod.POST)
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list";
	}

}
