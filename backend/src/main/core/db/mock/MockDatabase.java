package main.core.db.mock;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.core.db.Database;

public final class MockDatabase extends Database {

	public MockDatabase()
			throws SQLException, ClassNotFoundException {
		super("Mock", "", "", "", "");
	}

	@Override
	public ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeQuery(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(String sql) {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute(String sql, Object[] params) {
		// TODO Auto-generated method stub
	}

}
