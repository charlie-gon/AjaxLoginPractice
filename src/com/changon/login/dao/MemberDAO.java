package com.changon.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.changon.login.common.DAO;

public class MemberDAO extends DAO {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public String loginCheck(String id, String pwd) {
		
		String name = null;
		
		String sql = "SELECT MEMBERNAME FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD = ?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("membername"); // db에 사용하는 컬럼명!
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return name;
	}
	
	private void close() {
		
		try {
			if(rs != null)rs.close();
			if(psmt != null)psmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
