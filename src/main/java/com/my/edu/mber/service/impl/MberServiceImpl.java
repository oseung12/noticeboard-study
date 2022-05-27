package com.my.edu.mber.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.edu.board.vo.BoardVO;
import com.my.edu.mber.mapper.MberMapper;
import com.my.edu.mber.service.MberService;
import com.my.edu.mber.vo.MberVO;

@Service("mberService")
public class MberServiceImpl implements MberService{

	@Resource(name = "mberMapper")  
	private MberMapper mberMapper;
	
	/**
	 * 회원 목록
	 */
	@Override
	public List<MberVO> selectMberList(MberVO mberVO) throws Exception {
		return mberMapper.selectMberList(mberVO);
	}
	
	/**
	 * 회원 목록 총 갯수
	 */
	@Override
	public int selectMberListCnt(MberVO mberVO) throws Exception {
		return mberMapper.selectMberListCnt(mberVO);
	}
	
	/**
	 * 회원 검증
	 */
	@Override
	public MberVO selectMberComfirmInfo(MberVO mberVO) throws Exception {
		return mberMapper.selectMberComfirmInfo(mberVO);
	}
	
	/**
	 * 회원 아이디 중복체크
	 */
	@Override
	public int selectMberIdDupCheck(MberVO mberVO) throws Exception {
		return mberMapper.selectMberIdDupCheck(mberVO);
	}
	
	/**
	 * 회원 등록
	 */
	@Override
	public int mberInsert(MberVO mberVO) throws Exception {
		return mberMapper.mberInsert(mberVO);
	}
}