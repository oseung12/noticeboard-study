package com.my.edu.mber.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.edu.mber.service.MberService;
import com.my.edu.mber.vo.MberVO;
import com.my.edu.util.PaginationInfo;

@Controller
public class MberController {
	
	@Resource(name = "mberService")
	private MberService mberService;
	
	@RequestMapping(value = "/mber/mberList.do")
	public String selectMberList(HttpServletRequest request, Model model, MberVO mberVO) throws Exception {
		
		int currentPage = 1;
		int cntPerPage = 10;
		int pageSize = 10;
		
		if(mberVO.getCurrentPage() == 0 ) {
			mberVO.setCurrentPage(currentPage);
		}
		
		if(mberVO.getCntPerPage() == 0) {
			mberVO.setCntPerPage(cntPerPage);
		}
		
		if(mberVO.getPageSize() == 0) {
			mberVO.setPageSize(pageSize);
		}
		
		int totCnt = mberService.selectMberListCnt(mberVO);
		
		PaginationInfo pagination = new PaginationInfo(mberVO.getCurrentPage(), mberVO.getCntPerPage(), mberVO.getPageSize());
		
		pagination.setTotalRecordCount(totCnt);
		pagination.setFirstRecordIndex(pagination.getFirstRecordIndex());
		pagination.setLastRecordIndex(pagination.getLastRecordIndex());
		
		model.addAttribute("pagination", pagination);
		
		mberVO.setTotalRecordCount(pagination.getTotalPageCount());
		mberVO.setFirstRecordIndex(pagination.getFirstRecordIndex());
		mberVO.setLastRecordIndex(pagination.getLastRecordIndex());
		
		model.addAttribute("mberId", mberVO.getMberId());
		
	    List<MberVO> resultList = mberService.selectMberList(mberVO);
		model.addAttribute("resultList", resultList);
		
		return "/com/my/edu/mber/mberList";
	}
	
	@RequestMapping(value = "/mber/mberJoin.do")
	public String mberJoin(HttpServletRequest request, Model model, MberVO mberVO) throws Exception {
		
		return "/com/my/edu/mber/mberJoin";
	}
	
	@RequestMapping(value = "/mber/mberIdDupCheck.do")
	public ModelAndView mberIdDupCheck(HttpServletRequest request, Model model, MberVO mberVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int totCnt = 0;
		totCnt = mberService.selectMberIdDupCheck(mberVO);
		
		if(totCnt < 1) { // ?????? ??????
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "??????????????? ??????????????????.");
		} else { // ??????
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "?????? ????????? ??????????????????.\n?????? ???????????? ??????????????????.");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/mber/mberRegist.do")
	public ModelAndView mberRegist(HttpServletRequest request, Model model, MberVO mberVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int totCnt = 0;
		
		mberVO.setRegId("ADMIN");
		totCnt = mberService.mberInsert(mberVO);
		
		if(totCnt  > 0) { // ??????
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "??????????????? ?????????????????????.\n????????? ???????????? ???????????????.");
		} else { // ??????
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "??????????????? ?????????????????????.\n????????? ???????????? ???????????????.");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
}
