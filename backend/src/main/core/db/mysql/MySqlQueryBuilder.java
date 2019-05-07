package main.core.db.mysql;

import java.util.List;

import main.core.db.models.Table;

/**
 * Dynamically create a MySql query.
 * 
 * @author Alex Tigchelaar
 *
 */
public class MySqlQueryBuilder {

	/**
	 * Create a simple Select query without parameters.
	 * 
	 * @param tables Define which columns are collected. The Key must be the table
	 *               name. The Values must be all columns collected from the Key
	 *               table.
	 * @return Returns a String version of the select query.
	 */
	public static String buildSelectQuery(List<Table> selectTables) {
		return select(selectTables) + from(selectTables);
	}

	/**
	 * Create a simple Select query with parameters.
	 * 
	 * @param tables Define which columns are collected. The Key must be the table
	 *               name. The Values must be all columns collected from the Key
	 *               table.
	 * @param where  Define which columns are filtered on. The Key must be the table
	 *               name. The Values must be all columns included in the "where"
	 *               clause.
	 * @return Returns a String version of the select query.
	 */
	public static String buildSelectQuery(List<Table> selectTables, List<Table> whereTables) {
		return select(selectTables) + from(selectTables) + where(whereTables);
	}

//	/**
//	 * Create a Select query with joined tables and without parameters.
//	 * 
//	 * @param tables     Define which columns are collected. The Key must be the
//	 *                   table name. The Values must be all columns collected from
//	 *                   the Key table.
//	 * @param joinTables Define which tables are joined. The Key must be the table
//	 *                   name and column name. The Values must be the table name and
//	 *                   the column uniting the column referred to in the Key.
//	 * @return Returns a String version of the select query.
//	 */
//	public static String buildSelectJoinQuery(List<Table> selectTables,
//			List<Table> joinTables) {
//		String joins = "";
//		for(Table joinTable : joinTables) {
//			joins = joins + 
//		}
//		return select(selectTables) + from(selectTables) + join(joinTables);
//	}
//
//	/**
//	 * Create a Select query with joined tables and parameters.
//	 * 
//	 * @param selectTables Define which columns are collected. The Key must be the
//	 *                     table name. The Values must be all columns collected from
//	 *                     the Key table.
//	 * @param joinTables   Define which tables are joined. The Key must be the table
//	 *                     name and column name. The Values must be the table name
//	 *                     and the column uniting the column referred to in the Key.
//	 * @param where        Define which columns are filtered on. The Key must be the
//	 *                     table name. The Values must be all columns included in
//	 *                     the "where" clause.
//	 * @return Returns a String version of the select query.
//	 */
//	public static String buildSelectJoinQuery(List<Table> selectTables,
//			List<Table> joinTables, List<Table> whereTables) {
//		return select(selectTables) + from(selectTables) + join(joinTables) + where(whereTables);
//	}

	/**
	 * Create a simple Insert query.
	 * 
	 * @param insertTables Define into which table needs to be inserted. The Key
	 *                     must be the table name. The Values must be all columns
	 *                     with non-default values.
	 * @return Returns a String version of the insert query.
	 */
	public static String buildInsertQuery(Table insertTable) {
		return insert(insertTable) + values(insertTable.getColumns());
	}

	/**
	 * Create a simple Update query.
	 * 
	 * @param updateTables The table and columns that need updating. The Key must be
	 *                     the table name. The Values must be all columns that are
	 *                     being updated.
	 * @param where        The column names that need to match a certain
	 *                     requirement.
	 * @return Returns a String version of the update query.
	 */
	public static String buildUpdateQuery(Table updateTable, Table whereTable) {
		return update(updateTable.getName()) + set(updateTable.getColumns()) + where(whereTable);
	}

	/**
	 * Create a simple Delete query.
	 * 
	 * @param deleteTables The table name and column names that need to match a
	 *                     certain requirement.
	 * @return Returns a String version of the update query.
	 */
	public static String buildDeleteQuery(Table deleteTable) {
		return delete(deleteTable.getName()) + where(deleteTable);
	}

	/**
	 * Create the SELECT section of any query.
	 * 
	 * @param tables The table and columns from that table that need to be selected.
	 * @return Returns the SELECT section of the query.
	 */
	private static String select(List<Table> tables) {
		String select = "SELECT ";
		for (Table table : tables) {
			for (String column : table.getColumns()) {
				select = select
						+ (select.contentEquals("SELECT ") ? "" : ", ") + table.getName() + "." + column;
			}
		}
		return select;
	}

	/**
	 * Create the FROM section of any query.
	 * 
	 * @param tables The tables that need to be selected.
	 * @return Returns the FROM section of the query.
	 */
	private static String from(List<Table> tables) {
		String from = " FROM ";
		for(Table table : tables) {
			from = from + (from.contentEquals(" FROM ") ? "" : ", ") + table.getName();
		}
		return from;
	}
	
	/**
	 * Create the WHERE section of any query for a single table.
	 * @param table The table and columns that need to be filtered on.
	 * @return Returns the WHERE section of the query.
	 */
	private static String where(Table table) {
		String where = " WHERE ";
		for(String column : table.getColumns()) {
			where = where + (where.contentEquals(" WHERE ") ? table.getName() : " AND " + table.getName()) + "." + column + " = ?";
		}
		return where;
	}

	/**
	 * Create the WHERE section of any query for multiple tables.
	 * @param tables The tables and columns that need to be filtered on.
	 * @return Returns the WHERE section of the query.
	 */
	private static String where(List<Table> tables) {
		String where = " WHERE ";
		for(Table table : tables) {
			for(String column : table.getColumns()) {
			where = where + (where.contentEquals(" WHERE ") ? table.getName() : " AND " + table.getName()) + "." + column + " = ?";
			}
		}
		return where;
	}
	
//	/**
//	 * Create the JOIN section of any query.
//	 * @param tables The tables and columns that need to be linked together.
//	 * @return Returns the JOIN section of the query.
//	 */
//	private static String join(Table newTable, Table oldTable) {
//		 String join = " JOIN ";
//		 join = join + newTable.getName() + " ON " + oldTable.getName() + "." + oldTable.getColumns().get(0) + " = " + newTable.getName() + "." + newTable.getColumns().get(0);
//		 return join;
//	}
	
	/**
	 * Create the INSERT section of any query.
	 * @param table The table and columns that need to be inserted into.
	 * @return Returns the JOIN section of the query.
	 */
	private static String insert(Table table) {
		String insert = "INSERT INTO ";
		for(String column : table.getColumns()) {
			insert = insert + (insert.contentEquals("INSERT INTO ") ? table.getName() + " (" + column : ", " + column);
		}
		insert = insert + ")";
		return insert;
	}
	
	/**
	 * Create the VALUES section of any query.
	 * @param columns The columns that are inserted into.
	 * @return Returns the VALUES section of the query.
	 */
	private static String values(List<String> columns) {
		String values = " VALUES ";
		for(int i = 0; i < columns.size(); i += 1) {
			values = values + (values.contentEquals(" VALUES ") ? "(" : ", ") + "?";
		}
		values = values + ")";
		return values;
	}
	
	/**
	 * Creates the UPDATE section of any query.
	 * @param table The table that is being updated.
	 * @return Returns the UPDATE section of the query.
	 */
	private static String update(String table) {
		String update = "UPDATE ";
		update = update + table;
		return update;
	}
	
	/**
	 * Creates the SET section of any query.
	 * @param columns The tables that are being set.
	 * @return Returns the SET section of the query.
	 */
	private static String set(List<String> columns) {
		String set = " SET ";
		for(String column : columns) {
			set = set + (set.contentEquals(" SET ") ? "" : ", ") + column + " = ?";
		}
		return set;
	}
	
	/**
	 * Creates the DELETE section of any query.
	 * @param table The table that is being deleted from.
	 * @return Returns the DELETE section of the query.
	 */
	private static String delete(String table) {
		String delete = "DELETE FROM ";
		delete = delete + table;
		return delete;
	}
}
