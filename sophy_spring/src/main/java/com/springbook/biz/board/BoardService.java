package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	//CURD 기능의 메소드 구현
	
	//글 등록
	public void insertBoard(BoardVO boardVo);
	
	//글 수정 
	public void updateBoard(BoardVO boardVo);
	
	//글 삭제 
	public void deleteBoard(BoardVO boardVo);
	
	//글 상세 조회 
	BoardVO selectBoard(BoardVO boardVo);
	
	//글 목록 조회 
	List<BoardVO> getBoardList(BoardVO boardVo);

}
