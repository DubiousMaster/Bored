package main.core.database;

import main.core.database.mock.MockRepository;
import main.core.database.mysql.MySqlRepository;

public class RepositoryFactory {
	public static final DataRepository createRepository(DBTypes dbType) {
		switch(dbType) {
		case MOCK:
			return new MockRepository();
		case MY_SQL:
			return new MySqlRepository();
		default:
			throw new IllegalArgumentException("The given value is not a valid Database Type.");
		}
	}
}
