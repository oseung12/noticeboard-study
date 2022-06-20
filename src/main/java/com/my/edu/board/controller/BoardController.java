package com.my.edu.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.edu.board.service.BoardService;
import com.my.edu.board.vo.BoardVO;
import com.my.edu.mber.service.MberService;
import com.my.edu.mber.service.impl.MberServiceImpl;
import com.my.edu.mber.vo.MberVO;
import com.my.edu.util.PaginationInfo;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "mberService")
	private MberService mberService;
	
	/**
	 * 게시판목록페이지
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardList.do")
	public String selectBoardList(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		
		int currentPage = 1;
		int cntPerPage = 10;
		int pageSize = 10;
		
		if(boardVO.getCurrentPage() == 0 ) {
			boardVO.setCurrentPage(currentPage);
		}
		
		if(boardVO.getCntPerPage() == 0) {
			boardVO.setCntPerPage(cntPerPage);
		}
		
		if(boardVO.getPageSize() == 0) {
			boardVO.setPageSize(pageSize);
		}
		
		int totCnt = boardService.selectBoardListCnt(boardVO);
		
		PaginationInfo pagination = new PaginationInfo(boardVO.getCurrentPage(), boardVO.getCntPerPage(), boardVO.getPageSize());
		
		pagination.setTotalRecordCount(totCnt);
		pagination.setFirstRecordIndex(pagination.getFirstRecordIndex());
		pagination.setLastRecordIndex(pagination.getLastRecordIndex());
		
		model.addAttribute("pagination", pagination);
		
		boardVO.setTotalRecordCount(pagination.getTotalPageCount());
		boardVO.setFirstRecordIndex(pagination.getFirstRecordIndex());
		boardVO.setLastRecordIndex(pagination.getLastRecordIndex());
		
		model.addAttribute("mberId", boardVO.getMberId());
		
		List<BoardVO> resultList = boardService.selectBoardList(boardVO);
		model.addAttribute("resultList", resultList);
		
		
		return "/com/my/edu/board/boardList";
	}
	
	/**
	 * 게시판등록페이지
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardRegist.do")
	public String selectBoardRegist(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		
		model.addAttribute("mberId", boardVO.getMberId());
		return "/com/my/edu/board/boardRegist";
	}
	
	/**
	 * 게시판등록
	 * @param request
	 * @param model
	 * @param mberVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardInsert.do")
	public ModelAndView boardInsert(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int totCnt = 0;
		
		boardVO.setRegId(boardVO.getMberId());
		totCnt = boardService.boardInsert(boardVO);
		
		if(totCnt  > 0) { // 성공
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "등록되었습니다.");
		} else { // 실패
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "등록되지 않았습니다..\n관리자에게 문의해주세요.");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 게시판 상세 페이지
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardDetail.do")
	public String selectBoardDetail(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		
		model.addAttribute("mberId", boardVO.getMberId());
		
		boardVO = boardService.selectBoardDetail(boardVO);
		model.addAttribute("boardVO",boardVO);
		
		
		return "/com/my/edu/board/boardDetail";
	}
	
	/**
	 * 게시판 상세 정보(JSON)
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardDetailInfo.do")
	public ModelAndView boardDetailInfo(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		boardVO = boardService.selectBoardDetail(boardVO);
		model.addAttribute("boardVO",boardVO);
		mav.addObject("resultCode", "0");
		mav.addObject("resultMsg", "성공");
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 게시글 조회수 증가
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardHitsModify.do")
	public ModelAndView boardHitsModify(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int cnt = 0;
		boardVO.setUpdtId("USER");
		cnt = boardService.boardHitsUpdate(boardVO);
		mav.addObject("resultCode", "0");
		mav.addObject("resultMsg", "조회수가 증가되었습니다.");
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 게시판 삭제
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int totCnt = 0;
		System.out.println(boardVO.getBoardNo());
		boardVO.setUpdtId(boardVO.getMberId());
		totCnt = boardService.boardDelete(boardVO);
		
		if(totCnt  > 0) { // 성공
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "삭제되었습니다.");
		} else { // 실패
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "삭제되지않았습니다..\n관리자에게 문의해주세요.");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 게시판 수정
	 * @param request
	 * @param model
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/boardModify.do")
	public String boardModify(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		
		model.addAttribute("mberId", boardVO.getMberId());
		
		boardVO = boardService.selectBoardDetail(boardVO);
		model.addAttribute("boardVO",boardVO);
		
		
		return "/com/my/edu/board/boardModify";
	}
	
	
	@RequestMapping(value = "/board/boardUpdate.do")
	public ModelAndView boardUpdate(HttpServletRequest request, Model model, BoardVO boardVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int totCnt = 0;
		
		boardVO.setUpdtId(boardVO.getMberId());
		totCnt = boardService.boardUpdate(boardVO);
		
		if(totCnt  > 0) { // 성공
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "수정되었습니다.");
		} else { // 실패
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "수정되지 않았습니다..\n관리자에게 문의해주세요.");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
}
