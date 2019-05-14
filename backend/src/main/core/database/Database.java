package main.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.util.Pair;

/**
 * Represent a database and connect with it.
 * 
 * @author Alex Tigchelaar
 *
 */
public abstract class Database implements AutoCloseable {
	/**
	 * Represents the connection with the database.
	 */
	protected Connection connection;
	/**
	 * Define which driver is used.
	 */
	protected final String DATABASE_DRIVER;
	/**
	 * The database name.
	 */
	protected final String DATABASE_NAME;
	/**
	 * Sign in to the database using this password.
	 */
	protected final String DATABASE_PASSWORD;
	/**
	 * Define where the database can be found.
	 */
	protected final String DATABASE_URL;
	/**
	 * Sign in to the database using this username.
	 */
	protected final String DATABASE_USERNAME;

	/**
	 * Initialize the database.
	 * 
	 * @param name     The database name.
	 * @param url      Where the database can be found.
	 * @param driver   The database driver.
	 * @param username The username to sign in to the database.
	 * @param password The password to sign in to the database.
	 */
	protected Database(final String name, final String url, final String driver, final String username,
			final String password) {
		this.DATABASE_NAME = name;
		this.DATABASE_URL = this.correctUrl(url);
		this.DATABASE_DRIVER = driver;
		this.DATABASE_USERNAME = username;
		this.DATABASE_PASSWORD = password;
	}

	/**
	 * Close the connection to the database.
	 */
	@Override
	public void close() {
		try {
			this.connection.close();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Connect to the database.
	 * 
	 * @return Returns an object resembling the connection to the database.
	 * @throws SQLException Thrown when a connection could not be established i.e.
	 *                      the database could not be found.
	 */
	protected final Connection connect() throws SQLException {
		if (this.connection == null) {
			this.connection = DriverManager.getConnection(
					this.DATABASE_DRIVER + this.DATABASE_URL + "/" + this.DATABASE_NAME, this.DATABASE_USERNAME,
					this.DATABASE_PASSWORD);
		}
		return this.connection;
	}

	/**
	 * Verify and correct the URL to the database.
	 * 
	 * @param url The url as it's received.
	 * @return Returns a corrected URL.
	 */
	private String correctUrl(final String url) {
		if (url.charAt(url.length() - 1) == '/') {
			url.replace("/", "");
		}
		return url;
	}

	/**
	 * Execute a query without parameters.
	 * 
	 * @param sql The query sent to the database.
	 */
	public abstract void execute(final String sql);

	/**
	 * Execute a query with parameters.
	 * 
	 * @param sql    The query sent to the database.
	 * @param params Parameter values that go along with the query.
	 */
	public abstract void execute(final String sql, final List<Pair<String, Object>> params);

	/**
	 * Execute a query without parameters.
	 * 
	 * @param sql The query sent to the database.
	 * @return Returns the collected ResultSet.
	 */
	public abstract ResultSet executeQuery(final String sql);

	/**
	 * Execute a query with parameters.
	 * 
	 * @param sql    The query sent to the database.
	 * @param params Parameter values that go along with the query.
	 * @return Returns the collected ResultSet.
	 */
	public abstract ResultSet executeQuery(final String sql, final List<Pair<String, Object>> params);

	public abstract void executeInsert(String sql, List<Pair<String, Object>> params);
}
