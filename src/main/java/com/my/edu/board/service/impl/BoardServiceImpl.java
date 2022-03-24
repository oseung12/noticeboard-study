package com.my.edu.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.edu.board.mapper.BoardMapper;
import com.my.edu.board.service.BoardService;
import com.my.edu.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name = "boardMapper")
	private BoardMapper boardMapper;
	
	/*
	 * 게시판 목록
	 */
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		
		return boardMapper.selectBoardList(boardVO);
	}
	
	/**
	 * 게시판 등록
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public int boardInsert(BoardVO boardVO) throws Exception{
		
		return boardMapper.boardInsert(boardVO);
	}
	
	/**
	 * 게시판 상세
	 */
	@Override
	public BoardVO selectBoardDetail(BoardVO boardVO) throws Exception {
	
		return boardMapper.selectBoardDetail(boardVO);
	}

	/**
	 * 게시판 조회수 증가
	 */
	@Override
	public int boardHitsUpdate(BoardVO boardVO) throws Exception {

		return boardMapper.boardHitsUpdate(boardVO);
	}
	
	/**
	 * 게시판 삭제
	 */
	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardMapper.boardDelete(boardVO);
	}
	
	/**
	 * 게시판 수정
	 */
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return boardMapper.boardUpdate(boardVO);
	}
}
