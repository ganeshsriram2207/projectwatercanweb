package com.revature.wp.dao;

import java.sql.SQLException;

import com.revature.wp.exception.DBException;
import com.revature.wp.model.UserDetail;

public interface UserDAO 

{	
	
	UserDetail findByUsername(String name,String password) throws SQLException;
	
	UserDetail login(String name, String password) throws SQLException, DBException;
	
	UserDetail register(UserDetail user) throws SQLException, DBException;

	void setName(String name);

	void setPhone_number(String phone_number);

	void setPassword(String password);

	void setEmail_id(String email_id);

	void register(String name, long mobilenumber, String emailid, String password);
}



