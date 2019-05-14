package main.core.database.mysql.managers;

import java.sql.SQLException;

import main.core.database.Database;

public final class MySqlDatabaseFactory {
	public static final Database createMySqlDatabase(final MySqlDatabaseVersions dbVersion) throws ClassNotFoundException {
		switch(dbVersion) {
		case MySqlDatabase:
			try {
				return new MySqlDatabase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		throw new IllegalArgumentException("The provided Database version is not supported. Please try another version.");
	}
}
