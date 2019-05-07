package main.core.db.models;

import java.util.Arrays;

public class TableFactory {
	public static Table createTable(String tableName, String... columns) {
		return new Table(tableName, Arrays.asList(columns));
	}
}
