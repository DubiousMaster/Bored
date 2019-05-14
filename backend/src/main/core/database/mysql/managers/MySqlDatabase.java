package main.core.database.mysql.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.core.database.Database;
import main.util.Pair;

/**
 * Connect with a MySqlDatabase.
 *
 * @author Alex Tigchelaar
 *
 */
public final class MySqlDatabase extends Database {
	/**
	 * Define the MySql Java driver.
	 */
	private static final String DB_DRIVER = "jdbc:mysql://";
	/**
	 * Define the name of the database with which to connect.
	 */
	private static final String DB_NAME = "bored_v2";
	/**
	 * Define the password to sign in to the database with.
	 */
	private static final String DB_PASSWORD = "";
	/**
	 * Define the URL of the database.
	 */
	private static final String DB_URL = "localhost:3306";
	/**
	 * Define the username to sign in to the database with.
	 */
	private static final String DB_USERNAME = "root";

	/**
	 * Initialize a new MySqlDatabase instance.
	 *
	 * @throws ClassNotFoundException Thrown when the MySql java driver could not be
	 *                                found.
	 * @throws SQLException Thrown when a connection with the database could not be established.
	 */
	MySqlDatabase() throws ClassNotFoundException, SQLException {
		super(DB_NAME, DB_URL, DB_DRIVER, DB_USERNAME, DB_PASSWORD);
		Class.forName("com.mysql.cj.jdbc.Driver");
		super.connect();
	}

	@Override
	public final void execute(final String sql) {
		try {
			connection.createStatement().execute(sql);
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public final void execute(final String sql, final List<Pair<String, Object>> params) {
		try {
			final PreparedStatement statement = connection.prepareStatement(sql);
			List<Integer> setIndexes = new ArrayList<>();
			for (final Pair<String, Object> param : params) {
				final int index = getParam(sql, param.getKey(), setIndexes) + 1;
				final Object o = param.getValue();
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
				if (o instanceof Boolean) {
					statement.setBoolean(index, (boolean) o);
				}
				setIndexes.add(index);
			}
			statement.execute();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public final void executeInsert(final String sql, final List<Pair<String, Object>> params) {
		try {
			final PreparedStatement statement = connection.prepareStatement(sql);
			List<Integer> setIndexes = new ArrayList<>();
			for (final Pair<String, Object> param : params) {
				final int index = params.indexOf(param) + 1;
				final Object o = param.getValue();
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
				if (o instanceof Boolean) {
					statement.setBoolean(index, (boolean) o);
				}
				setIndexes.add(index);
			}
			statement.execute();
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public final ResultSet executeQuery(final String sql) {
		try {
			return connection.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public final ResultSet executeQuery(final String sql, final List<Pair<String, Object>> params) {
		try {
			final PreparedStatement statement = connection.prepareStatement(sql);
			List<Integer> setIndexes = new ArrayList<>();
			for(Pair<String, Object> param : params) {
				final int index = getParam(sql, param.getKey(), setIndexes) + 1;
				final Object o = param.getValue();
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
				if (o instanceof Boolean) {
					statement.setBoolean(index, (boolean) o);
				}
				setIndexes.add(index);
			}
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get the parameter value of the given key.
	 * @param query The SQL query.
	 * @param key The insert key.
	 * @return Returns the index value of the given key parameter.
	 */
	private int getParam(String query, String key, List<Integer> setIndexes) {
		String[] params = query.split("[?]");
		for(int i = 0; i < params.length; i += 1) {
			String param = params[i];
			if(param.contains(key)) {
				if(!setIndexes.contains(i + 1)) { 
					return i;
				}
			}
		}
		throw new IllegalArgumentException("The given key does not exist in the query.");
	}
}
