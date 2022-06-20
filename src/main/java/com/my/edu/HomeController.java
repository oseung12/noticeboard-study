package com.my.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.edu.mber.service.MberService;
import com.my.edu.mber.vo.MberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Resource(name = "mberService")
	private MberService mberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		
		
		return "main";
	}
	
	@RequestMapping(value = "/mberConfirmAjax.do")
	public ModelAndView mberConfirmAjax(HttpServletRequest request, Model model) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String p_mberId = request.getParameter("mberId");
		String p_mberPw = request.getParameter("mberPw");
		
		MberVO mberVO = new MberVO();
		mberVO.setMberId(p_mberId);
		mberVO.setMberPw(p_mberPw);
		
		mberVO = mberService.selectMberComfirmInfo(mberVO);
		
		if (mberVO != null) {
			mav.addObject("mberId", mberVO.getMberId());
			mav.addObject("mberPw",mberVO.getMberPw());
			
			mav.addObject("resultCode", "0");
			mav.addObject("resultMsg", "성공");
		} else {
			mav.addObject("resultCode", "-1");
			mav.addObject("resultMsg", "로그인 정보가 일치하지 않습니다.\n아이디 또는 비밀번호를 입력해주세요");
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value = "/logout.do")
	public String logOut(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		session.invalidate(); //세션에 있는 데이터 모두 삭제
		
		return "redirect:/";
	}
}

