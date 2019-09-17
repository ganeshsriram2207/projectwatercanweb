package com.revature.wp.services;

import java.sql.SQLException;

import com.revature.wp.dao.UserDAO;
import com.revature.wp.dao.UserDAOImpl;
import com.revature.wp.exception.DBException;
import com.revature.wp.model.UserDetail;

public class UserService {

	UserDAO user = new UserDAOImpl();

	public void register(UserDetail details) {

		try {
			user.register(details);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}

	}

	public UserDetail login(String name, String setPassword) throws SQLException, DBException {

		UserDetail details = null;
		details.login(name, setPassword);
		return details;
	}
}
