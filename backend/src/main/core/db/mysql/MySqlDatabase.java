package main.core.db.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import main.core.db.Database;

public final class MySqlDatabase extends Database {
	private static final String DB_DRIVER = "jdbc:mysql://";
	private static final String DB_NAME = "bored";
	private static final String DB_PASSWORD = "";
	private static final String DB_URL = "localhost:3306";
	private static final String DB_USERNAME = "root";

	public MySqlDatabase() throws ClassNotFoundException, SQLException {
		super(DB_NAME, DB_URL, DB_DRIVER, DB_USERNAME, DB_PASSWORD);
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	@Override
	public final ResultSet executeQuery(final String sql) {
		ResultSet set = null;
		try {
			set = super.connect().createStatement().executeQuery(sql);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	@Override
	public final ResultSet executeQuery(final String sql, final Object[] values) {
		ResultSet set = null;
		try {
			final PreparedStatement statement = super.connect().prepareStatement(sql);
			for (int i = 0; i < values.length; i += 1) {
				final int index = i + 1;
				final Object o = values[i];
				if (o instanceof Double) {
					statement.setDouble(index, (double) o);
				}
				if (o instanceof Integer) {
					statement.setInt(index, (int) o);
				}
				if (o instanceof String) {
					statement.setString(index, (String) o);
				}
				if (o instanceof Date) {
					statement.setDate(index, new java.sql.Date(((Date) o).getTime()));
				}
			}
			set = statement.executeQuery();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
}
