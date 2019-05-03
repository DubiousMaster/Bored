package main.core.db;

import java.sql.SQLException;

import main.core.db.mock.MockDatabase;
import main.core.db.mysql.MySqlDatabase;

class DatabaseFactory {
	static Database getDatabase(DBTypes databaseType) {
		try {
			switch (databaseType) {
			case MOCK:
				return new MockDatabase();
			case MY_SQL:
				return new MySqlDatabase();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
