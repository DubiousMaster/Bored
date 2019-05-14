package main.core;

import main.api.bored.DataFetch;
import main.core.database.RepositoryFactory;
import main.core.database.DBTypes;

/**
 * Application is the main class of the application.
 *
 * @author Alex Tigchelaar
 *
 */
public final class Application {
	/**
	 * The main method runs and launches the application officially.
	 * 
	 * @param args The arguments sent with the call on the application.
	 */
	public static final void main(final String[] args) {
		for(int i = 0; i < 20; i += 1) {
			RepositoryFactory.createRepository(DBTypes.MY_SQL).storeActivity(DataFetch.fetchData());;
		}
	}
}
