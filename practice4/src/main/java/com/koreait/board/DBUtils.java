package com.koreait.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
	
	public static Connection getCon() throws Exception {
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/boardvo3"; //jdbc:DBMS명://IP주소:포트번호(디폴트3306)/DB명
		final String USER_NAME = "root";
		final String PASSWORD = "kjy132";
		
		Class.forName(DRIVER); //생략가능
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("연결 성공!!");
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null); 
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		// con : 다리 역할 , ps : 쿼리 실행역할 , rs : 셀렉트떄만 쓸 결과 담을 것.
		// insert, delete, update 는 영향 받은 행 : ? 얘를 int형으로 받을거
		// 열리는 순서 : 1. con, 2. ps, 3. rs 이고,
		// 닫는 순서는 여는 
		
		if(rs != null) { // CRUD 때 앞 두개 무조건, 뒤는 select 때만 추가적으로
			try {rs.close(); } catch(SQLException e) { e.printStackTrace(); }
		}
		if(ps != null) {
			try {ps.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
			if(con != null) {
				try {con.close(); } catch(SQLException e) {e.printStackTrace();} 
			}
	}
	
	
}




