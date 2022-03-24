package com.my.edu.board.mapper;

import java.util.List;

import com.my.edu.board.vo.BoardVO;

public interface BoardMapper {

	/**
	 * 게시판 목록
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시판 등록
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int boardInsert(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시판 상세
	 */
	public BoardVO selectBoardDetail(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시판 조회수 증가
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int boardHitsUpdate(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시판 삭제
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int boardDelete(BoardVO boardVO) throws Exception;
	
	/**
	 * 게시판 수정
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int boardUpdate(BoardVO boardVO) throws Exception;
}

	
