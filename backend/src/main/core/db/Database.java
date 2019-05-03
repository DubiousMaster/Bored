package main.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Database implements AutoCloseable {
	private Connection connection;
	
	protected final String DATABASE_DRIVER;
	protected final String DATABASE_NAME;
	protected final String DATABASE_PASSWORD;
	protected final String DATABASE_URL;
	protected final String DATABASE_USERNAME;

	public Database(final String name, final String url, final String driver,
			final String username, final String password) throws SQLException, ClassNotFoundException {
		this.DATABASE_NAME = name;
		if (url.charAt(url.length() - 1) == '/') {
			url.replace("/", "");
		}
		this.DATABASE_URL = url;
		this.DATABASE_DRIVER = driver;
		this.DATABASE_USERNAME = username;
		this.DATABASE_PASSWORD = password;
	}
	
	public abstract ResultSet executeQuery(final String sql);
	public abstract ResultSet executeQuery(final String sql, final Object[] params);
	
	protected final Connection connect() throws SQLException {
		if(this.connection == null) {
			this.connection = DriverManager.getConnection(this.DATABASE_DRIVER + this.DATABASE_URL + "/" + this.DATABASE_NAME, this.DATABASE_USERNAME, this.DATABASE_PASSWORD);
		}
		return this.connection;
	}
	
	@Override
	public void close() throws SQLException {
		this.connection.close();
	}
}
