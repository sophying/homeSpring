package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	

	
	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;
	
	// SQL 
	// seq 를 nvl 로 활용하여 null 값이 없도록 null 값일 경우 0 으로 치환 후 1을 더함
	// 만일 숫자가 있다면 가장큰 max 값에 1을 더하여 insert 진행 
	private final String S_BOARD_1_INSERT = 	
			"insert into S_BOARD_1 (SEQ, TITLE, WRITER, CONTENT) values((select nvl(max(SEQ),0)+1 from S_BOARD_1), ?, ?, ?)";
	
	private final String S_BOARD_1_UPDATE =
			"update S_BOARD_1 set TITLE=? , CONTENT=? where SEQ=? ";
	private final String S_BOARD_1_DELETE = 
			"delete S_BOARD_1 where SEQ=?";
	private final String S_BOARD_1_SELECT = 
			"selet * from S_BOARD_1 where SEQ=?";

	private final String S_BOARD_1_LIST = 
			"select * from S_BOARD_1 order by SEQ desc";
	
	
	public void insertBoard(BoardVO boardVo) {
		
		System.out.println("insertBoard() 실행 ______\n");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(S_BOARD_1_INSERT);
			pstmt.setString(1, boardVo.getTitle());
			pstmt.setString(2, boardVo.getWriter());
			pstmt.setString(3, boardVo.getContent());
			
			// insert 를 한 것으로 하나의 행을 더하는 것으로 작업은 마치게 됨.
			// next()로 값을 불러오는 작업은 진행하지 않으므로 아래와 같이 작성 
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}


	public void updateBoard(BoardVO boardVo) {
	System.out.println("__________[ JDBC   updateBoard() 수행 ]____________");
		
		try {
			
			conn = JDBCUtil.getConnection();;
			pstmt = conn.prepareStatement(S_BOARD_1_UPDATE);
			pstmt.setString(1, boardVo.getTitle());
			pstmt.setString(2, boardVo.getContent());
			pstmt.setInt(3,  boardVo.getSeq());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	



	public void deleteBoard(BoardVO boardVo) {
System.out.println("__________[ JDBC   deleteBoard() 수행 ]____________");
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(S_BOARD_1_DELETE);
			pstmt.setInt(1,  boardVo.getSeq());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(pstmt, conn);
			
		}
	}



	public BoardVO selectBoard(BoardVO boardVo) {
System.out.println("__________[ JDBC   BoardVO getBoard() 수행 ]____________");		
		
		BoardVO board= null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(S_BOARD_1_SELECT);
			pstmt.setInt(1,  boardVo.getSeq());
			
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next()) {
				
				board = new BoardVO();
				board.setSeq(resultSet.getInt("SEQ"));
				board.setTitle(resultSet.getString("TITLE"));
				board.setWriter(resultSet.getString("WRITER"));
				board.setContent(resultSet.getString("CONTENT"));
				board.setRegDate(resultSet.getDate("REGDATE"));
				board.setCnt(resultSet.getInt("CNT"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			JDBCUtil.close(resultSet, pstmt, conn);
		}
		return board;
	}


	public List<BoardVO> getBoarList(BoardVO boardVo) {
System.out.println("__________[ JDBC   List<BoardVO> getBoarList() 수행 ]____________");			
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(S_BOARD_1_LIST);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				
				BoardVO board = new BoardVO();
				board.setSeq(resultSet.getInt("SEQ"));
				board.setTitle(resultSet.getString("TITLE"));
				board.setWriter(resultSet.getString("WRITER"));
				board.setContent(resultSet.getString("CONTENT"));
				board.setRegDate(resultSet.getDate("REGDATE"));
				board.setCnt(resultSet.getInt("CNT"));
				
				boardList.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			JDBCUtil.close(resultSet, pstmt, conn);
			
		}
		return boardList;
	}
	
	
	
}
