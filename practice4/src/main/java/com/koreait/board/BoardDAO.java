package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public static int insertBoard(BoardVO a) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board3 (title,ctnt)" + " VALUES" + "(?,?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, a.getTitle());
			ps.setString(2, a.getCtnt());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);

		}
		return 0;

	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT title, iboard, regdt FROM t_board3";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String title = rs.getString("title");
				// String ctnt = rs.getString("ctnt"); //내용 필요 xxxx
				String regdt = rs.getString("regdt");
				int iboard = rs.getInt("iboard");

				BoardVO a = new BoardVO();
				list.add(a);
				// a.setCtnt(ctnt);
				a.setIboard(iboard);
				a.setRegdt(regdt);
				a.setTitle(title);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);

		}
		return list;
	}

	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board3 where iboard = ?";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard); // 몇번 골랐는지 알아야함
			rs = ps.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				// int iboard = rs.getInt("iboard"); 매개변수로 받기때문에 필요xxx

				BoardVO a = new BoardVO();
				a.setCtnt(ctnt);
				a.setTitle(title);
				a.setIboard(iboard);
				a.setRegdt(regdt);

				return a;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);

		}
		return null;

	}
	public static int updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board3 " 
				+ " SET title = ? " 
				+ " , ctnt = ? " 
				+ " WHERE iBoard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());

			System.out.println(ps.toString());
			return ps.executeUpdate(); // insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static int delBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_board3 where iboard=?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());

			return ps.executeUpdate(); // insert,update,delete

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}
	
	
	
}
