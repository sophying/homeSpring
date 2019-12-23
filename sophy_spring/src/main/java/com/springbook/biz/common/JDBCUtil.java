package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 디비 연결 잭 생성 
public class JDBCUtil {
	
	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패 ");
		}
		return null;
		
	}
	
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		
		//pstmt.close
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		
		//conn.close
		if (conn != null) {
			
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet resultSet, PreparedStatement pstmt, Connection conn) {
		//pstmt.close
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		
		//conn.close
		if (conn != null) {
			
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
		
		//resultSet.close
		if (resultSet != null) {
			
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				resultSet = null;
			}
		}
		
		
		
	}

}
