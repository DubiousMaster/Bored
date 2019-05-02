package main.core.db.mysql;

/**
 * Dynamically create a MySql query.
 * @author Alex Tigchelaar
 *
 */
class MySqlQueryBuilder {
	
	static String buildSelectQuery(String[] columns, String[] tables) {
		return select(columns) + from(tables) + ";";
	}
	
	static String buildSelectQuery(String[] columns, String[] tables, String[] whereKeys) {
		return select(columns) + from(tables) + where(whereKeys) + ";";
	}
	
	static String buildInsertQuery(String table, String[] valueKeys) {
		return insert(table) + values(valueKeys) + ";";
	}
	
	static String buildUpdateQuery(String table, String[] setKeys, String[] whereKeys) {
		return update(table) + set(setKeys) + where(whereKeys) + ";";
	}
	
	static String buildDeleteQuery(String table, String[] whereKeys) {
		return delete(table) + where(whereKeys) + ";";
	}
	
	private static String select(String[] columns) {
		String select = "SELECT ";
		for(String column : columns) {
			select = select + (column == columns[0] ? column : ", " + column);
		}
		return select;
	}
	
	private static String insert(String table) {
		return "INSERT INTO " + table;
	}
	
	private static String update(String table) {
		return "UPDATE " + table; 
	}
	
	private static String delete(String table) {
		return "DELETE " + table;
	}
	
	private static String from(String[] tables) {		
		String from = " FROM ";
		for(String table : tables) {
			from = from + (table == tables[0] ? table : ", " + table);
		}
		return from;
	}
	
	private static String values(String[] columns) {
		String values = " VALUES(";
		for(String column : columns) {
			values = values + column == columns[0] ? column : ", " + column;
		}
		return (values + ")");
	}
	
	private static String set(String[] columns) {
		String set = " SET ";
		for(String column : columns) {
			set = set + (column == columns[0] ? column : ", " + column) + " = ?";
		}
		return set;
	}
	
	private static String where(String[] columns) {
		String where = " WHERE ";
		for(String column : columns) {
			where = where + (column == columns[0] ? column : ", " + column) + " = ?";
		}
		return where;
	}
}
