package main.core.db.mysql;

import java.sql.SQLException;

import main.core.db.DatabaseConnector;

public class MySqlConnector extends DatabaseConnector {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public MySqlConnector() throws SQLException, ClassNotFoundException {
		super("bored", "localhost:3306", "jdbc:mysql://", USERNAME, PASSWORD);
	}
}
