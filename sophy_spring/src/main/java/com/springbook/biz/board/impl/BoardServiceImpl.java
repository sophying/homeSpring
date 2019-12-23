package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO boardVo) {
		boardDao.insertBoard(boardVo);
	}

	@Override
	public void updateBoard(BoardVO boardVo) {
		boardDao.updateBoard(boardVo);
	}

	@Override
	public void deleteBoard(BoardVO boardVo) {
		boardDao.deleteBoard(boardVo);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVo) {
		return boardDao.selectBoard(boardVo); 
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVo) {
		return boardDao.getBoarList(boardVo);
	}

}
