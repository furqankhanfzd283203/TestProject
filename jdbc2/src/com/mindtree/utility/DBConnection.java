package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.exception.UtilityException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc2_database";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "FURQAN@991123";

	public static Connection connectionToDB() throws UtilityException {
		Connection connection = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		//} catch (ClassNotFoundException e) {
		//	throw new UtilityException("The driver class was not found");
		} catch (SQLException e) {
			throw new UtilityException("There was some problem with connection");
		}

		return connection;
	}


}
