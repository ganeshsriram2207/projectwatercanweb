package com.revature.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.revature.wp.connection.ConnectionUtil;
import com.revature.wp.exception.DBException;
import com.revature.wp.model.UserDetail;
import com.revature.wp.services.CanAvailability;
import com.revature.wp.services.HomePage;

public class UserDAOImpl implements UserDAO {
	static UserDetail obj = new UserDetail();

	public UserDetail login(String name, String password) throws SQLException, DBException {

		UserDetail ud = new UserDetail();
		UserDAO test = new UserDAOImpl();
		ud = test.findByUsername(name, password);

		try {

			if (name.equals(name) && password.equals(password)) {
				System.out.println("Login Succesfull!!! ");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				String uname = ud.getName().toUpperCase();
				System.out.println("Welcome:" + uname);
				System.out.println(name+password);
				CanAvailability.order();
			}

		} catch (SQLException e) {

			throw new RuntimeException("You Have Entered Invalid Data!!!.");
		}
		return ud;
		} 
	

	@SuppressWarnings("static-access")
	public UserDetail register(UserDetail user)
			throws SQLException, DBException {
		Connection con = ConnectionUtil.getConnection();
		System.out.println("Welcome To GS Water Treatment Plant");
		HomePage hp = null;
		PreparedStatement pstmt = null;
		int rows;
			String sql_stmnt = "insert into Login(name,mobile_number,Email_id,password) values (?,?,?,?)";
			pstmt = con.prepareStatement(sql_stmnt);
			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getMobilenumber());
			pstmt.setString(3, user.getEmailid());
			pstmt.setString(4, user.getPassword());
		rows = pstmt.executeUpdate();
		if (rows == 1) {
			System.out.println("Number Of Rows Inserted:" + " " + rows + "\n");
			System.out.println("Your Details Have Been Registered Successfully");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			System.out.println("Redirecting To HomePage \n");
			hp.homepage();
		} else {
			System.out.println("NO Rows Inserted");
		}
		return user;
	}

	public void setavailablecans(int noOfCans) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql_stmnt = "insert into set_available_cans (available_cans) values (?)";
			pstmt = con.prepareStatement(sql_stmnt);

			pstmt.setInt(1, noOfCans);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("Number Of Rows Inserted:" + " " + rows);
			} else {
				System.out.println("NO Rows Inserted");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
			pstmt.close();
		}
	}

	public void orderedcans(int order) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql_stmnt = "insert into ordered_cans(cans_ordered) values (?)";
			pstmt = con.prepareStatement(sql_stmnt);
			pstmt.setInt(1, order);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("Number Of Rows Inserted After Ordered:" + " " + rows);
			} else {
				System.out.println("NO Rows Inserted After Ordered");
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			con.close();
			pstmt.close();
		}
	}

	public void availablecansafterordered(int can) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql_stmnt = "insert into available_cans_after_ordered(available_cans_after_ordered) values (?)";
			pstmt = con.prepareStatement(sql_stmnt);
			pstmt.setInt(1, can);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println(" Rows Inserted After Ordered Got Completed:" + " " + rows);
			} else {
				System.out.println("NO Rows Inserted After Ordered");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			con.close();
			pstmt.close();
		}
	}

	public UserDetail findByUsername(String name, String password) throws SQLException {
		UserDetail ud = null;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql_stmnt = "select name,password from Login where name = ? and password = ?";
			pstmt = con.prepareStatement(sql_stmnt);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			ud = new UserDetail();

			if (rs.next()) {
				ud = toRow(rs);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			pstmt.close();
		}
		return ud;

	}

	private UserDetail toRow(ResultSet rs) throws SQLException {

		String name = rs.getString("Name");
		String password = rs.getString("password");
		UserDetail user = new UserDetail();
		user.setName(name);
		user.setPassword(password);
		return user;
	}


	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}


	public void setPhone_number(String phone_number) {
		// TODO Auto-generated method stub
		
	}


	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}


	public void setEmail_id(String email_id) {
		// TODO Auto-generated method stub
		
	}


	public void register(String name, long mobilenumber, String emailid, String password) {
		// TODO Auto-generated method stub
		
	}
}
