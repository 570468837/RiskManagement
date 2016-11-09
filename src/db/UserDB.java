package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import utils.DatabaseUtils;


public class UserDB {

	static String sql_insert_account = "insert into `account` values(?, ?, ?, ?);";
	static String sql_check = "select * from `account` where id = ? and password = ? and role = ?;";
	
	public void insertAccount(User user) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_insert_account);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getRole());
		pstmt.executeUpdate();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
	}
	
	public boolean checkPassword(User user) throws SQLException {
		Connection conn = DatabaseUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql_check);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getRole());
		ResultSet rs = pstmt.executeQuery();
		boolean flag = rs.next();
		rs.close();
		pstmt.close();
		DatabaseUtils.closeConnection(conn);
		return flag;
	}
	
}
