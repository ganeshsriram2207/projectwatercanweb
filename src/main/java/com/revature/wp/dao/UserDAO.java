package com.revature.wp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.wp.exception.DBException;
import com.revature.wp.model.UserDetail;

public interface UserDAO 

{	
	
	UserDetail findByUsername(String name,String password) throws SQLException;
	
	UserDetail login(String name, String password) throws SQLException, DBException;
	
	void register(UserDetail use) throws SQLException, DBException;

	void setName(String name);

	void setPhone_number(String phone_number);

	void setPassword(String password);

	void setEmail_id(String email_id);

	void setavailablecans(int noOfCans) throws SQLException;
	
	List<UserDetail> findAll() throws SQLException;


}



