package com.my.edu.mber.mapper;

import java.util.List;

import com.my.edu.mber.vo.MberVO;

public interface MberMapper {

	/**
	 * 회원 목록
	 * @param mberVO
	 * @return
	 * @throws Exception
	 */
	public List<MberVO> selectMberList(MberVO mberVO) throws Exception;
	
	/**
	 * 회원 목록 총 갯수
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int selectMberListCnt(MberVO mberVO) throws Exception;
	
	/**
	 * 회원 검증
	 * @param mberVO
	 * @return
	 * @throws Exception
	 */
	public MberVO selectMberComfirmInfo(MberVO mberVO) throws Exception;
	
	/**
	 * 회원 아이디 중복 체크
	 * @param mberVO
	 * @return
	 * @throws Exception
	 */
	public int selectMberIdDupCheck(MberVO mberVO) throws Exception;
	
	/**
	 * 회원 등록
	 * @param mberVO
	 * @return
	 * @throws Exception
	 */
	public int mberInsert(MberVO mberVO) throws Exception;
}